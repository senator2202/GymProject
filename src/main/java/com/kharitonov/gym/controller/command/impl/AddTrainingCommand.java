package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

public class AddTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddTrainingCommand.class);
    private final UserService userService = UserServiceImpl.getInstance();
    private final TrainingService trainingService = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(RequestParameter.TRAINER);
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        if (((Client) user).getBoughtTrainings() == 0) {
            LOGGER.error("You have 0 bought trainings!");
            return PagePath.SCHEDULE;
        }
        int userId = user.getAccount().getId();
        String stringDate = request.getParameter(RequestParameter.TRAINING_DATE);
        Date date = Date.valueOf(stringDate);
        try {
            List<Training> trainings;
            int trainerId = userService.findId(name);
            trainingService.addTraining(trainerId, userId, date);
            restoreRequestAttributes(request);
            trainings = trainingService.findClientTrainings(userId);
            request.setAttribute(RequestAttributeName.TRAININGS, trainings);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.SCHEDULE;
    }
}
