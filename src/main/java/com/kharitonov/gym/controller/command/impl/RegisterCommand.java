package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.PagePath;
import com.kharitonov.gym.controller.RequestAttributeName;
import com.kharitonov.gym.controller.RequestAttributeValue;
import com.kharitonov.gym.controller.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.service.db.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements ActionCommand {
    private static final Logger LOGGER =
            LogManager.getLogger(RegisterCommand.class);
    private final UserService service = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameter.LOGIN);
        String password = request.getParameter(RequestParameter.PASSWORD);
        String email = request.getParameter(RequestParameter.EMAIL);
        String page;
        try {
            service.registerUser(login, password, email, UserRole.CLIENT);
            request.setAttribute(RequestAttributeName.AUTHENTICATION_RESULT,
                    RequestAttributeValue.REGISTER_SUCCESS);
            page = PagePath.AUTHENTICATION_RESULT;
        } catch (ServiceException e) {
            LOGGER.error("Unable to register new user!", e);
            request.setAttribute(RequestAttributeName.AUTHENTICATION_RESULT,
                    e.getLocalizedMessage());
            page = PagePath.REGISTER;
        }
        return page;
    }
}
