package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.TrainerApplication;
import com.kharitonov.gym.service.TrainerApplicationService;
import com.kharitonov.gym.service.impl.TrainerApplicationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminMainCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminMainCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<TrainerApplication> applications = service.getAllApplications();
            String locale = (String) request.getSession().getAttribute(SessionAttributeName.ADMIN_LOCALE);
            if (locale == null) {
                request.getSession().setAttribute(SessionAttributeName.ADMIN_LOCALE, SessionAttributeValue.EN_LOCALE);
            }
            request.setAttribute(RequestAttributeName.APPLICATIONS_TAB, RequestAttributeValue.ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.REGISTRATIONS_TAB, RequestAttributeValue.NOT_ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.FEEDBACKS_TAB, RequestAttributeValue.NOT_ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.APPLICATIONS, applications);
        } catch (ServiceException e) {
            LOGGER.error("Applications loading error!", e);
        }
        return PagePath.ADMIN_MAIN;
    }
}
