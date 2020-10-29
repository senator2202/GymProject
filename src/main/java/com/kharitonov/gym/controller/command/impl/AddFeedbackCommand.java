package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.controller.command.RequestAttributeName;
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
        String page;
        try {
            if (service.addFeedback(name, email, subject, message)) {
                request.getSession().setAttribute(RequestAttributeName.FEEDBACK_SENT, true);
                page = ProjectPage.INDEX.getDirectUrl();
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
