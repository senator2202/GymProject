package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
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
        String id = request.getParameter(RequestParameterName.APPLICATION_ID);
        String page;
        try {
            if (service.deleteApplication(id)) {
                restoreRequestAttributes(request);
                List<TrainerApplication> applications =
                        (List<TrainerApplication>) request.getAttribute(RequestAttributeName.APPLICATIONS);
                int userId = Integer.parseInt(id);
                applications.stream().filter(a -> a.getUser().getAccount().getId() == userId).map(applications::remove);
                request.setAttribute(RequestAttributeName.APPLICATIONS, applications);
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
