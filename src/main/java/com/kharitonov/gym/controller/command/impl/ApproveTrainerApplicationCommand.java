package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestParameter;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.service.TrainerApplicationService;
import com.kharitonov.gym.service.impl.TrainerApplicationServiceImpl;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ApproveTrainerApplicationCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ApproveTrainerApplicationCommand.class);
    private final TrainerApplicationService appService = TrainerApplicationServiceImpl.getInstance();
    private final UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String institution = request.getParameter(RequestParameter.APPLICATION_INSTITUTION);
        String stringId = request.getParameter(RequestParameter.APPLICATION_ID);
        int id = Integer.parseInt(stringId);
        String stringGraduation = request.getParameter(RequestParameter.APPLICATION_GRADUATION);
        int graduation = Integer.parseInt(stringGraduation);
        String instagram = request.getParameter(RequestParameter.APPLICATION_INSTAGRAM);
        try {
            List<TrainerApplication> applications;
            userService.appointTrainer(id, institution, graduation, instagram);
            applications = appService.deleteApplication(id);
            request.setAttribute(RequestAttributeName.APPLICATIONS, applications);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.ADMIN_MAIN;
    }
}
