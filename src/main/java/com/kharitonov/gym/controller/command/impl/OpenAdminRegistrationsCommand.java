package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminRegistrationsCommand implements ActionCommand {
    private static final int DEFAULT_USERS_NUMBER = 30;
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminRegistrationsCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            String daysParameter = request.getParameter(RequestParameter.RECENT_DAYS);
            int days = daysParameter != null
                    ? Integer.parseInt(daysParameter)
                    : DEFAULT_USERS_NUMBER;
            List<User> users = service.findRecentUsers(days);
            request.setAttribute(RequestAttributeName.DAYS_NUMBER, days);
            request.setAttribute(RequestAttributeName.APPLICATIONS_TAB, RequestAttributeValue.NOT_ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.TRAININGS_TAB, RequestAttributeValue.NOT_ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.REGISTRATIONS_TAB, RequestAttributeValue.ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.RECENT_USERS, users);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.ADMIN_REGISTRATIONS;
    }
}
