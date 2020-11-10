package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestAttributeValue;
import com.kharitonov.gym.util.RequestParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminRegistrationsCommand implements ActionCommand {
    private static final String DEFAULT_DAYS = "30";
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
                page = PagePath.ERROR_404.getDirectUrl();
            } else {
                days = days == null ? DEFAULT_DAYS : days;
                request.setAttribute(RequestAttributeName.DAYS, days);
                request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.REGISTRATIONS_TAB);
                request.setAttribute(RequestAttributeName.RECENT_USERS, users);
                page = PagePath.ADMIN_REGISTRATIONS.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
