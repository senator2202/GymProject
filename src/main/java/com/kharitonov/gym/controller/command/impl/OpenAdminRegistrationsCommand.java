package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import com.kharitonov.gym.validator.ValidationError;
import com.kharitonov.gym.validator.ValidationErrorSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminRegistrationsCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminRegistrationsCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String days = request.getParameter(RequestParameterName.RECENT_DAYS);
        String page;
        try {
            List<User> users = service.findRecentUsers(days);
            ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
            if (errorSet.contains(ValidationError.INVALID_NUMBER_FORMAT)) {
                errorSet.clear();
                page = ProjectPage.ERROR_404.getDirectUrl();
            } else {
                request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.REGISTRATIONS_TAB);
                request.setAttribute(RequestAttributeName.RECENT_USERS, users);
                page = ProjectPage.ADMIN_REGISTRATIONS.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
