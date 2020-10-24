package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.ServletPath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SetTrainingDoneCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(SetTrainingDoneCommand.class);
    private final TrainingService service = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameterName.TRAINING_ID);
        try {
            service.setTrainingDone(id);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return ServletPath.SCHEDULE;
    }
}
