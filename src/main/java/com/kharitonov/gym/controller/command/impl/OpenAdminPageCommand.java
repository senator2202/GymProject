package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.service.TrainerApplicationService;
import com.kharitonov.gym.service.impl.TrainerApplicationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminPageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminPageCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<TrainerApplication> applications = service.getAllApplications();
            request.setAttribute(RequestAttributeName.APPLICATIONS, applications);
        } catch (ServiceException e) {
            LOGGER.error("Applications loading error!", e);
        }
        return PagePath.ADMIN;
    }
}
