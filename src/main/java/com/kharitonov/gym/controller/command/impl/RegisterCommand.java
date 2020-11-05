package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.ActiveUsersMap;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
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
            HttpSession session = request.getSession();
            Optional<User> optionalUser = service.registerUser(parameters);
            if (optionalUser.isPresent()) {
                ActiveUsersMap map = ActiveUsersMap.getInstance();
                User user = optionalUser.get();
                map.put(user.getAccount().getId(), user.getAccount().getIsActive());
                session.setAttribute(SessionAttributeName.USER, user);
                session.setAttribute(RequestAttributeName.CONFIRMATION_SENT, true);
            } else {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                session.setAttribute(SessionAttributeName.REGISTRAION_MAP, parameters);
                session.setAttribute(SessionAttributeName.ERROR_SET, errorSet.getAllAndClear());
            }
            page = ProjectPage.INDEX.getDirectUrl();
        } catch (ServiceException e) {
            LOGGER.error("Unable to register new user!", e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
