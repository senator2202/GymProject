package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Training;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
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
        UserRole role = user.getAccount().getRole();
        String page;
        try {
            if (role == UserRole.CLIENT) {
                doClientScenario(request, user);
            }
            if (role == UserRole.TRAINER) {
                doTrainerScenario(request, user);
            }
            page = PagePath.SCHEDULE;
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR;
        }
        return page;
    }

    private void doClientScenario(HttpServletRequest request, User user) throws ServiceException {
        int userId = user.getAccount().getId();
        List<User> trainers = userService.findAllTrainers();
        List<Training> trainings = trainingService.findClientTrainings(userId);
        request.setAttribute(RequestAttributeName.TRAINERS, trainers);
        request.setAttribute(RequestAttributeName.TRAININGS, trainings);
    }

    private void doTrainerScenario(HttpServletRequest request, User user) throws ServiceException {

    }
}
