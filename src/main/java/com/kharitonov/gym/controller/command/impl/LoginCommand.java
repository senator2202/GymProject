package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        String page;
        try {
            Optional<User> optional = service.findUser(login, password);
            if (optional.isPresent()) {
                User user = optional.get();
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttributeName.USER, user);
                if (user.getAccount().getRole() != UserRole.ADMIN) {
                    page = PagePath.INDEX;
                } else {
                    page = PagePath.ADMIN_MAIN;
                }
            } else {
                page = PagePath.LOGIN;
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR;
        }
        return page;
    }
}
