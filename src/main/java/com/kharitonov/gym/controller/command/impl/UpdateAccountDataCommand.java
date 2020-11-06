package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateAccountDataCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdateAccountDataCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        String email = request.getParameter(RequestParameterName.EMAIL);
        String locale = request.getParameter(RequestParameterName.LOCALE);
        String newPassword = request.getParameter(RequestParameterName.NEW_PASSWORD);
        String repeatNewPassword = request.getParameter(RequestParameterName.REPEAT_NEW_PASSWORD);
        String page;
        try {
            if (service.updateAccountData(user, email, locale, newPassword, repeatNewPassword)) {
                page = ProjectPage.PERSONAL_ACCOUNT.getServletCommand();
            } else {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                if (errorSet.contains(ValidationError.CHANGE_EMAIL_EXISTS)) {
                    session.setAttribute(SessionAttributeName.ERROR_SET, errorSet.getAllAndClear());
                    page = ProjectPage.PERSONAL_ACCOUNT.getServletCommand();
                } else {
                    page = ProjectPage.ERROR_404.getDirectUrl();
                }
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
