package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UpdateTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdateTrainingCommand.class);
    private final TrainingService service = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameterName.TRAINING_ID);
        String date = request.getParameter(RequestParameterName.TRAINING_DATE);
        String time = request.getParameter(RequestParameterName.TRAINING_TIME);
        String description = request.getParameter(RequestParameterName.TRAINING_DESCRIPTION);
        try {
            service.updateTraining(id, date, time, description);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return ProjectPage.SCHEDULE.getServletCommand();
    }
}
