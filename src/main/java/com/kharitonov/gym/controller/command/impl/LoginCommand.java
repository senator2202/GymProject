package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.PagePath;
import com.kharitonov.gym.controller.RequestAttributeName;
import com.kharitonov.gym.controller.RequestAttributeValue;
import com.kharitonov.gym.controller.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final Logger LOGGER =
            LogManager.getLogger(LoginCommand.class);
    private final UserService service = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String page;
        try {
            if (service.checkLoginPassword(login, password)) {
                request.setAttribute(RequestAttributeName.AUTHENTICATION_RESULT,
                        RequestAttributeValue.LOGIN_SUCCESS);
                page = PagePath.AUTHENTICATION_RESULT;
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
