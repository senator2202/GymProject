package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.NavigationPath;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class UpdateTrainingDescriptionCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdateTrainingDescriptionCommand.class);
    private final TrainingService service = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        int trainingId = Integer.parseInt(request.getParameter(RequestParameterName.TRAINING_ID));
        String description = request.getParameter(RequestParameterName.TRAINING_DESCRIPTION);
        try {
            service.updateDescription(trainingId, description);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return NavigationPath.SCHEDULE;
    }
}
