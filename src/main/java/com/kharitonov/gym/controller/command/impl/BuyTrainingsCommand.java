package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestParameter;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.User;
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
        String parameter = request.getParameter(RequestParameter.TRAININGS_NUMBER);
        int trainingsNumber = Integer.parseInt(parameter);
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        try {
            userService.buyTrainings((Client) user, trainingsNumber, DEFAULT_TRAINING_COST);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.SCHEDULE;
    }
}
