package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class BuyTrainingsCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(BuyTrainingsCommand.class);
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String trainingsNumber = request.getParameter(RequestParameterName.TRAININGS_NUMBER);
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        String page;
        try {
            if (userService.buyTrainings(client, trainingsNumber)) {
                page = PagePath.SCHEDULE.getServletCommand();
            } else {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                if (errorSet.contains(ValidationError.LOW_BALANCE)) {
                    request.getSession().setAttribute(SessionAttributeName.ERROR_SET, errorSet.getAllAndClear());
                    page = PagePath.SCHEDULE.getServletCommand();
                } else {
                    page = PagePath.ERROR_404.getDirectUrl();
                }
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
