package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.util.RequestAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenHomeCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(BuyTrainingsCommand.class);
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            List<Trainer> trainers = userService.findAllTrainers();
            request.setAttribute(RequestAttributeName.TRAINERS, trainers);
            page = ProjectPage.HOME.getDirectUrl();
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
