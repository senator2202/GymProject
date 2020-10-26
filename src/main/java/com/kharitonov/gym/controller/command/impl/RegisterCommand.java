package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RegisterCommand implements ActionCommand {
    private static final Logger LOGGER =
            LogManager.getLogger(RegisterCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter(RequestParameterName.REGISTRATION_LOGIN);
        String password = request.getParameter(RequestParameterName.REGISTRATION_PASSWORD);
        String repeatPassword = request.getParameter(RequestParameterName.REPEAT_PASSWORD);
        String email = request.getParameter(RequestParameterName.REGISTRATION_EMAIL);
        Map<String, String> parameters = new HashMap<>();
        parameters.put(RequestParameterName.REGISTRATION_LOGIN, login);
        parameters.put(RequestParameterName.REGISTRATION_PASSWORD, password);
        parameters.put(RequestParameterName.REPEAT_PASSWORD, repeatPassword);
        parameters.put(RequestParameterName.REGISTRATION_EMAIL, email);
        String page;
        try {
            Optional<User> optionalUser = service.registerUser(parameters);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                HttpSession session = request.getSession();
                clearSessionAttributesExceptUser(request);
                session.setAttribute(SessionAttributeName.USER, user);
                session.setAttribute(RequestAttributeName.CONFIRMATION_SENT, true);
                page = ProjectPage.INDEX.getDirectUrl();
            } else {
                clearSessionAttributesExceptUser(request);
                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    request.getSession().setAttribute(entry.getKey(), entry.getValue());
                }
                request.getSession().setAttribute(SessionAttributeName.LOGIN_EMAIL_EXISTS, true);
                page = ProjectPage.INDEX.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error("Unable to register new user!", e);
            page = ProjectPage.ERROR_404.getDirectUrl();
        }
        return page;
    }
}
