package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.TrainerApplicationService;
import com.kharitonov.gym.service.impl.TrainerApplicationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SendTrainerApplicationCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(SendTrainerApplicationCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        int id = user.getAccount().getId();
        String institution = request.getParameter(RequestParameter.INSTITUTION);
        String stringYear = request.getParameter(RequestParameter.GRADUATION_YEAR);
        int year = Integer.parseInt(stringYear);
        String instagram = request.getParameter(RequestParameter.INSTAGRAM_LINK);
        try {
            if (service.sendApplication(id,institution,year,instagram)) {
                request.setAttribute(RequestAttributeName.APPLICATION_RESULT, true);
            } else {
                request.setAttribute(RequestAttributeName.ALREADY_SENT, true);
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            request.setAttribute(RequestAttributeName.APPLICATION_RESULT, false);
        }
        return PagePath.PERSONAL_PROFILE;
    }
}
