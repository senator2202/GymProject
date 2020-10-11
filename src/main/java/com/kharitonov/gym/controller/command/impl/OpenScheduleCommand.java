package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenScheduleCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenScheduleCommand.class);
    private final UserServiceImpl userService = UserServiceImpl.getInstance();
    private final TrainingServiceImpl trainingService = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        int userId = user.getAccount().getId();
        String page;
        try {
            List<User> trainers = userService.findAllTrainers();
            List<Training> trainings = trainingService.findClientTrainings(userId);
            request.setAttribute(RequestAttributeName.TRAINERS, trainers);
            request.setAttribute(RequestAttributeName.TRAININGS, trainings);
            page = PagePath.SCHEDULE;
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR;
        }
        return page;
    }
}
