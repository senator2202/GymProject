package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.FeedbackService;
import com.kharitonov.gym.service.impl.FeedbackServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddFeedbackCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(AddFeedbackCommand.class);
    private final FeedbackService service = FeedbackServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter(RequestParameterName.FEEDBACK_SENDER_NAME);
        String email = request.getParameter(RequestParameterName.FEEDBACK_SENDER_EMAIL);
        String subject = request.getParameter(RequestParameterName.FEEDBACK_SUBJECT);
        String message = request.getParameter(RequestParameterName.FEEDBACK_MESSAGE);
        try {
            service.addFeedback(name, email, subject, message);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        String page = getPreviousPage(request);
        return ProjectPage.INDEX.getDirectUrl();
    }
}
