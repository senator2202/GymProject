package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UpdateDiscountCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdateDiscountCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameterName.CLIENT_ID);
        String discount = request.getParameter(RequestParameterName.PERSONAL_DISCOUNT);
        String page;
        try {
            service.updateDiscount(id, discount);
            page = ProjectPage.ADMIN_REGISTRATIONS.getServletCommand();
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
