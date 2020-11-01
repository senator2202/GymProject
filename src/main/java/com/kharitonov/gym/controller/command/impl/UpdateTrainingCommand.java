package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.service.TrainingService;
import com.kharitonov.gym.model.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
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
        String page;
        try {
            if (service.updateTraining(id, date, time, description)) {
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
