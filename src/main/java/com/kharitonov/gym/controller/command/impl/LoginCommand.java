package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestAttributeValue;
import com.kharitonov.gym.controller.command.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
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
