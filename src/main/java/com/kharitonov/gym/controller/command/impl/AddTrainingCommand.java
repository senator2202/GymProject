package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.RequestParameter;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.TrainingService;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class AddTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddTrainingCommand.class);
    private final UserService userService = UserServiceImpl.getInstance();
    private final TrainingService trainingService = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(RequestParameter.TRAINER);
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        int userId = user.getAccount().getId();
        String stringDate = request.getParameter(RequestParameter.TRAINING_DATE);
        Date date = Date.valueOf(stringDate);
        try {
            int trainerId = userService.findId(name);
            trainingService.addTraining(trainerId, userId, date);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
