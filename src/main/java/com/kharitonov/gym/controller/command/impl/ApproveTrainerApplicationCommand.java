package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.service.TrainerApplicationService;
import com.kharitonov.gym.model.service.impl.TrainerApplicationServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ApproveTrainerApplicationCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ApproveTrainerApplicationCommand.class);
    private final TrainerApplicationService appService = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String institution = request.getParameter(RequestParameterName.APPLICATION_INSTITUTION);
        String id = request.getParameter(RequestParameterName.APPLICATION_ID);
        String graduation = request.getParameter(RequestParameterName.APPLICATION_GRADUATION);
        String instagram = request.getParameter(RequestParameterName.APPLICATION_INSTAGRAM);
        String page;
        try {
            if (appService.approveApplication(id, institution, graduation, instagram)) {
                page = PagePath.ADMIN_MAIN.getServletCommand();
            } else {
                page = PagePath.ERROR_404.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
