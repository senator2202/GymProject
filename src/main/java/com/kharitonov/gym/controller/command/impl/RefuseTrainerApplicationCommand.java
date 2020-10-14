package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.service.TrainerApplicationService;
import com.kharitonov.gym.service.impl.TrainerApplicationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RefuseTrainerApplicationCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(RefuseTrainerApplicationCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String stringId = request.getParameter(RequestParameterName.APPLICATION_ID);
        int id = Integer.parseInt(stringId);
        try {
            List<TrainerApplication> applications = service.deleteApplication(id);
            request.setAttribute(RequestAttributeName.APPLICATIONS, applications);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.ADMIN_MAIN;
    }
}
