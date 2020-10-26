package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
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
import java.util.stream.Collectors;

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
            page = ProjectPage.SCHEDULE.getDirectUrl();
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_404.getDirectUrl();
        }
        return page;
    }

    private void doClientScenario(HttpServletRequest request, User user) throws ServiceException {
        int userId = user.getAccount().getId();
        List<User> trainers = userService.findAllTrainers();
        List<Training> trainings = trainingService.findClientTrainings(userId);
        List<Training> planned = trainings.stream().filter(t -> !t.isDone()).collect(Collectors.toList());
        List<Training> previous = trainings.stream().filter(t -> t.isDone()).collect(Collectors.toList());
        request.setAttribute(RequestAttributeName.PLANNED_TRAININGS, planned);
        request.setAttribute(RequestAttributeName.PREVIOUS_TRAININGS, previous);
        request.setAttribute(RequestAttributeName.TRAINERS, trainers);
    }

    private void doTrainerScenario(HttpServletRequest request, User user) throws ServiceException {
        int userId = user.getAccount().getId();
        List<Training> trainings = trainingService.findTrainerTrainings(userId);
        List<Training> planned = trainings.stream().filter(t -> !t.isDone()).collect(Collectors.toList());
        List<Training> previous = trainings.stream().filter(t -> t.isDone()).collect(Collectors.toList());
        request.setAttribute(RequestAttributeName.PLANNED_TRAININGS, planned);
        request.setAttribute(RequestAttributeName.PREVIOUS_TRAININGS, previous);
    }
}
