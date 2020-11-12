package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.model.service.TrainerApplicationService;
import com.kharitonov.gym.model.service.impl.TrainerApplicationServiceImpl;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestAttributeValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This command allows the admin to open his main page (page with all trainer applications)
 */
public class OpenAdminMainCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminMainCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            List<TrainerApplication> applications = service.getAllApplications();
            request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.APPLICATIONS_TAB);
            request.setAttribute(RequestAttributeName.APPLICATIONS, applications);
            page = PagePath.ADMIN_MAIN.getDirectUrl();
        } catch (ServiceException e) {
            LOGGER.error("Applications loading error!", e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
