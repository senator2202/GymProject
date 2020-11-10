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

public class RefuseTrainerApplicationCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(RefuseTrainerApplicationCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String id = request.getParameter(RequestParameterName.APPLICATION_ID);
        String page;
        try {
            if (service.deleteApplication(id)) {
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
