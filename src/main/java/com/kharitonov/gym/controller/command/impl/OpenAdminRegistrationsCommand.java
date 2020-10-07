package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminRegistrationsCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminRegistrationsCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<User> users = service.getRecentUsers();
            request.setAttribute(RequestAttributeName.RECENT_USERS, users);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.ADMIN_REGISTRATIONS;
    }
}
