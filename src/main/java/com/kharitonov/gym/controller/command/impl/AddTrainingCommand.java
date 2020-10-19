package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AddTrainingCommand implements ActionCommand {
    private static final String SECONDS_POSTFIX = ":00";
    private static final Logger LOGGER = LogManager.getLogger(AddTrainingCommand.class);
    private final UserService userService = UserServiceImpl.getInstance();
    private final TrainingService trainingService = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(RequestParameterName.TRAINER);
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        int boughtTrainings = client.getBoughtTrainings();
        if (boughtTrainings == 0) {
            LOGGER.error("You have 0 bought trainings!");
            return NavigationPath.SCHEDULE;
        }
        int userId = client.getAccount().getId();
        String stringDate = request.getParameter(RequestParameterName.TRAINING_DATE);
        Date date = Date.valueOf(stringDate);
        String stringTime = request.getParameter(RequestParameterName.TRAINING_TIME) + SECONDS_POSTFIX;
        Time time = Time.valueOf(stringTime);
        try {
            List<Training> trainings;
            int trainerId = userService.findId(name);
            trainingService.addTraining(trainerId, userId, date, time);
            client.setBoughtTrainings(boughtTrainings - 1);
            restoreRequestAttributes(request);
            trainings = trainingService.findClientTrainings(userId);
            request.setAttribute(RequestAttributeName.TRAININGS, trainings);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return NavigationPath.SCHEDULE;
    }
}
