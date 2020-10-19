package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.lang.Math.min;

public class OpenAdminRegistrationsCommand implements ActionCommand {
    private static final int DEFAULT_USERS_NUMBER = 30;
    private static final int DEFAULT_ROWS = 10;
    private static final int DEFAULT_OFFSET = 1;
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminRegistrationsCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            String daysParameter = request.getParameter(RequestParameterName.RECENT_DAYS);
            int days = daysParameter != null
                    ? Integer.parseInt(daysParameter)
                    : DEFAULT_USERS_NUMBER;
            List<User> users = service.findRecentUsers(days);
            List<User> usersPerPage;
            String stringOffset = request.getParameter(RequestParameterName.TABLE_OFFSET);
            int offset = stringOffset == null ? DEFAULT_OFFSET : Integer.parseInt(stringOffset);
            request.setAttribute(RequestAttributeName.DAYS_NUMBER, days);
            request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.REGISTRATIONS_TAB);
            usersPerPage = users.subList((offset - DEFAULT_OFFSET) * DEFAULT_ROWS, min(offset * DEFAULT_ROWS, users.size()));
            request.setAttribute(RequestAttributeName.RECENT_USERS, users);
            request.setAttribute(RequestParameterName.TOTAL_RECENT_USERS, users.size());
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return NavigationPath.ADMIN_REGISTRATIONS;
    }
}
