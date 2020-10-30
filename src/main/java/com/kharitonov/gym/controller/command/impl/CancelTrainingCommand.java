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
        String trainingId = request.getParameter(RequestParameterName.TRAINING_ID);
        String page;
        try {
            if (service.deleteTraining(trainingId, clientId)) {
                restoreRequestAttributes(request);
                List<Training> trainings = (List<Training>) request.getAttribute(RequestAttributeName.PLANNED_TRAININGS);
                int id = Integer.parseInt(trainingId);
                trainings.stream().filter(t -> t.getTrainingId() == id).findFirst().map(trainings::remove);
                client.setBoughtTrainings(client.getBoughtTrainings() + 1);
            } else {
                page = ProjectPage.ERROR_404.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return ProjectPage.SCHEDULE.getServletCommand();
    }
}
