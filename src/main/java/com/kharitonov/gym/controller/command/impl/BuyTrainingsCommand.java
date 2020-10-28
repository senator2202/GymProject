package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class BuyTrainingsCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(BuyTrainingsCommand.class);
    private static final double DEFAULT_TRAINING_COST = 20;
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String trainingsNumber = request.getParameter(RequestParameterName.TRAININGS_NUMBER);
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        String page;
        try {
            if (!userService.buyTrainings(client, trainingsNumber, DEFAULT_TRAINING_COST)) {
                request.getSession().setAttribute(SessionAttributeName.LOW_BALANCE, true);
            }
            page = ProjectPage.SCHEDULE.getServletCommand();
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
