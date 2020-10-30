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
import java.util.List;

public class AddTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddTrainingCommand.class);
    private static final int INVALID_ID = -1;
    private final UserService userService = UserServiceImpl.getInstance();
    private final TrainingService trainingService = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        int clientId = client.getAccount().getId();
        String trainerId = request.getParameter(RequestParameterName.SELECTED_TRAINER_ID);
        String date = request.getParameter(RequestParameterName.TRAINING_DATE);
        String time = request.getParameter(RequestParameterName.TRAINING_TIME);
        String page;
        try {
            int trainingId = trainingService.addTraining(trainerId, clientId, date, time);
            if (trainingId == INVALID_ID) {
                page = ProjectPage.ERROR_404.getDirectUrl();
            } else {
                Training training = trainingService.findTrainingById(trainingId).get();
                restoreRequestAttributes(request);//restoring client schedule page attributes
                List<Training> planned = (List<Training>) request.getAttribute(RequestAttributeName.PLANNED_TRAININGS);
                planned.add(training);
                client.setBoughtTrainings(client.getBoughtTrainings() - 1);
                page = ProjectPage.SCHEDULE.getServletCommand();
            }

        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
