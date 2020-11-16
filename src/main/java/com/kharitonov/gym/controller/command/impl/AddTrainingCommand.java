package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.service.TrainingService;
import com.kharitonov.gym.model.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * This command allows the client to add new training
 */
public class AddTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddTrainingCommand.class);
    private static final int INVALID_ID = -1;
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
            if (trainingId != INVALID_ID) {
                client.setBoughtTrainings(client.getBoughtTrainings() - 1);
                page = PagePath.SCHEDULE.getServletPath();
            } else {
                page = PagePath.ERROR_404.getDirectUrl();
            }

        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
