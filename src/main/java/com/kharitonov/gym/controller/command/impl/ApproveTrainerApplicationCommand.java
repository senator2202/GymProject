package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestParameterName;
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
        String institution = request.getParameter(RequestParameterName.APPLICATION_INSTITUTION);
        String id = request.getParameter(RequestParameterName.APPLICATION_ID);
        String graduation = request.getParameter(RequestParameterName.APPLICATION_GRADUATION);
        String instagram = request.getParameter(RequestParameterName.APPLICATION_INSTAGRAM);
        String page;
        try {
            if (appService.approveApplication(id, institution, graduation, instagram)) {
                restoreRequestAttributes(request);
                List<TrainerApplication> applications =
                        (List<TrainerApplication>) request.getAttribute(RequestAttributeName.APPLICATIONS);
                int userId = Integer.parseInt(id);
                applications.stream().filter(a -> a.getUser().getAccount().getId() == userId).map(applications::remove);
                page = ProjectPage.ADMIN_MAIN.getServletCommand();
            } else {
                page = ProjectPage.ERROR_404.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
