package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CancelTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddTrainingCommand.class);
    private final TrainingService service = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        int clientId = client.getAccount().getId();
        int trainingId = Integer.parseInt(request.getParameter(RequestParameterName.TRAINING_ID));
        try {
            List<Training> trainings;
            service.deleteTraining(trainingId, clientId);
            client.setBoughtTrainings(client.getBoughtTrainings() + 1);
            trainings = service.findClientTrainings(clientId);
            request.setAttribute(RequestAttributeName.TRAININGS, trainings);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return NavigationPath.SCHEDULE;
    }
}
