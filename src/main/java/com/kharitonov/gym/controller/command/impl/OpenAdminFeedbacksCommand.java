package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestAttributeValue;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.service.FeedbackService;
import com.kharitonov.gym.service.impl.FeedbackServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OpenAdminFeedbacksCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminFeedbacksCommand.class);
    private final FeedbackService service = FeedbackServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        try {
            List<Feedback> feedbacks = service.findAllFeedbacks();
            request.setAttribute(RequestAttributeName.APPLICATIONS_TAB, RequestAttributeValue.NOT_ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.REGISTRATIONS_TAB, RequestAttributeValue.NOT_ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.FEEDBACKS_TAB, RequestAttributeValue.ACTIVE_TAB);
            request.setAttribute(RequestAttributeName.FEEDBACKS, feedbacks);
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return PagePath.ADMIN_FEEDBACKS;
    }
}
