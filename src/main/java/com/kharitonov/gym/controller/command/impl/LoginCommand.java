package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.PagePath;
import com.kharitonov.gym.controller.RequestAttributeName;
import com.kharitonov.gym.controller.RequestAttributeValue;
import com.kharitonov.gym.controller.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private final UserService service = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String page;
        if (service.checkLoginPassword(login, password)) {
            request.setAttribute(RequestAttributeName.AUTHENTICATION_RESULT,
                    RequestAttributeValue.LOGIN_SUCCESS);
            page = PagePath.AUTHENTICATION_RESULT;
        } else {
            request.setAttribute(RequestAttributeName.AUTHENTICATION_RESULT,
                    RequestAttributeValue.LOGIN_ERROR);
            page = PagePath.LOGIN;
        }
        return page;
    }
}
