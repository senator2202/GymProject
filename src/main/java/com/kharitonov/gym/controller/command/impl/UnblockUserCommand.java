package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.ServletPath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UnblockUserCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UnblockUserCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter(RequestParameterName.USER_ID));
        try {
            service.unblockUser(id);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return ServletPath.ADMIN_REGISTRATIONS;
    }
}
