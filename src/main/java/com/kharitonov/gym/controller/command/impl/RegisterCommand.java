package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.NavigationPath;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RegisterCommand implements ActionCommand {
    private static final Logger LOGGER =
            LogManager.getLogger(RegisterCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameterName.LOGIN);
        String password = request.getParameter(RequestParameterName.PASSWORD);
        String email = request.getParameter(RequestParameterName.EMAIL);
        String page;
        try {
            User user = service.registerUser(login, password, email);
            HttpSession session = request.getSession();
            session.setAttribute(SessionAttributeName.USER, user);
            page = NavigationPath.INDEX;
        } catch (ServiceException e) {
            LOGGER.error("Unable to register new user!", e);
            page = NavigationPath.ERROR;
        }
        return page;
    }
}
