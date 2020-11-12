package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Feedback;
import com.kharitonov.gym.model.service.FeedbackService;
import com.kharitonov.gym.model.service.impl.FeedbackServiceImpl;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestAttributeValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * This command allows the admin to open page with feedbacks, left by all users
 */
public class OpenAdminFeedbacksCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(OpenAdminFeedbacksCommand.class);
    private final FeedbackService service = FeedbackServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        try {
            List<Feedback> feedbacks = service.findAllFeedbacks();
            request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.FEEDBACKS_TAB);
            request.setAttribute(RequestAttributeName.FEEDBACKS, feedbacks);
            page = PagePath.ADMIN_FEEDBACKS.getDirectUrl();
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
