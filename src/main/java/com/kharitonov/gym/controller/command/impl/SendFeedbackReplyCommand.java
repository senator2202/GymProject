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

public class SendFeedbackReplyCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(SendFeedbackReplyCommand.class);
    private final FeedbackService service = FeedbackServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter(RequestParameterName.FEEDBACK_REPLY_EMAIL);
        String subject = request.getParameter(RequestParameterName.FEEDBACK_REPLY_SUBJECT);
        String message = request.getParameter(RequestParameterName.FEEDBACK_REPLY_MESSAGE);
        String id = request.getParameter(RequestParameterName.FEEDBACK_ID);
        String page;
        try {
            if (service.sendReplyMessage(id, email, subject, message)) {
                page = ProjectPage.ADMIN_FEEDBACKS.getServletCommand();
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
