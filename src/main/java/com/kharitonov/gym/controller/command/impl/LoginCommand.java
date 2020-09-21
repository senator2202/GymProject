package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER =
            LogManager.getLogger(LoginCommand.class);
    private final UserServiceImpl service = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String page;
        try {
            Optional<UserRole> optional =
                    service.checkLoginPassword(login, password);
            if (optional.isPresent()) {
                HttpSession session = request.getSession();
                session.setAttribute(SessionAttributeName.IS_LOGGED,
                        SessionAttributeValue.LOGIN_SUCCESS);
                page = PagePath.INDEX;
            } else {
                request.setAttribute(RequestAttributeName.AUTHENTICATION_RESULT,
                        RequestAttributeValue.LOGIN_ERROR);
                page = PagePath.LOGIN;
            }
        } catch (ServiceException e) {
            LOGGER.error("Database access error!", e);
            page = PagePath.ERROR;
        }
        return page;
    }
}
