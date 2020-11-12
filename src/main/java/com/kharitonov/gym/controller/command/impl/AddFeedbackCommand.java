package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.service.FeedbackService;
import com.kharitonov.gym.model.service.impl.FeedbackServiceImpl;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * This command allows the user to add feedback
 */
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
                page = PagePath.INDEX.getDirectUrl();
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
