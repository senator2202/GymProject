package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class RateTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(RateTrainingCommand.class);
    private final TrainingService trainingService = TrainingServiceImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String trainingId = request.getParameter(RequestParameterName.TRAINING_ID);
        String trainingRating = request.getParameter(RequestParameterName.TRAINING_RAITING);
        String trainerId = request.getParameter(RequestParameterName.TRAINER_ID);
        String page;
        try {
            if (trainingService.rateTraining(trainingId, trainingRating, trainerId)) {
                page = ProjectPage.SCHEDULE.getServletCommand();
            } else {
                page = ProjectPage.ERROR_404.getDirectUrl();
            }

        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
