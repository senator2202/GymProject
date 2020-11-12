package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.ActiveUsersMap;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This command allows the guest to login
 */
public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.LOGIN_PASSWORD);
        Map<String, String> parameters = new HashMap<>();
        parameters.put(RequestParameterName.LOGIN, login);
        parameters.put(RequestParameterName.LOGIN_PASSWORD, password);
        try {
            HttpSession session = request.getSession();
            Optional<User> optional = service.findUser(parameters);
            if (optional.isPresent()) {
                User user = optional.get();
                session.setAttribute(SessionAttributeName.USER, user);
                if (user.getAccount().getRole() == UserRole.ADMIN) {
                    page = PagePath.ADMIN_MAIN.getServletCommand();
                } else {
                    ActiveUsersMap map = ActiveUsersMap.getInstance();
                    map.put(user.getAccount().getId(), user.getAccount().getIsActive());
                    page = PagePath.INDEX.getDirectUrl();
                }
            } else {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                session.setAttribute(SessionAttributeName.LOGIN_MAP, parameters);
                session.setAttribute(SessionAttributeName.ERROR_SET, errorSet.getAllAndClear());
                page = PagePath.INDEX.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
