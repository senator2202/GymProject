package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();
    private static final String VALID_POSTFIX = "Valid";

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        Map<String, String> parameters = new HashMap<>();
        parameters.put(RequestParameterName.LOGIN, login);
        parameters.put(RequestParameterName.PASSWORD, password);
        try {
            Optional<User> optional = service.findUser(parameters);
            if (optional.isPresent()) {
                User user = optional.get();
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttributeName.USER, user);
                if (user.getAccount().getRole() != UserRole.ADMIN) {
                    page = NavigationPath.INDEX;
                } else {
                    page = NavigationPath.OPEN_ADMIN_MAIN;
                }
            } else {
                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    request.getSession().setAttribute(entry.getKey() + VALID_POSTFIX, entry.getValue());
                }
                request.getSession().setAttribute(SessionAttributeName.INCORRECT_LOGIN_PASSWORD, true);
                page = NavigationPath.LOGIN_INDEX;
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = NavigationPath.ERROR;
        }
        return page;
    }
}
