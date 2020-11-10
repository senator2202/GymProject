package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.ActiveUsersMap;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class BlockUserCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(BlockUserCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameterName.USER_ID);
        String page;
        try {
            if (service.blockUser(id)) {
                int userId = Integer.parseInt(id);
                ActiveUsersMap map = ActiveUsersMap.getInstance();
                map.put(userId, false);
                page = PagePath.ADMIN_REGISTRATIONS.getServletCommand();
            } else {
                page = PagePath.ERROR_404.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
