package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.TrainerApplicationService;
import com.kharitonov.gym.model.service.impl.TrainerApplicationServiceImpl;
import com.kharitonov.gym.model.validator.ValidationError;
import com.kharitonov.gym.model.validator.ValidationErrorSet;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * This command allows the client to send the application to be a trainer
 */
public class SendTrainerApplicationCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(SendTrainerApplicationCommand.class);
    private final TrainerApplicationService service = TrainerApplicationServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        int id = user.getAccount().getId();
        String institution = request.getParameter(RequestParameterName.INSTITUTION);
        String year = request.getParameter(RequestParameterName.GRADUATION_YEAR);
        String instagram = request.getParameter(RequestParameterName.INSTAGRAM_LINK);
        String page;
        try {
            if (service.sendApplication(id, institution, year, instagram)) {
                String prevPage = getPreviousPage(request);
                PagePath pagePath = Arrays.stream(PagePath.values())
                        .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(PagePath.PERSONAL_ACCOUNT);
                page = pagePath.getServletCommand();
            } else {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                if (errorSet.contains(ValidationError.APPLICATION_EXISTS)) {
                    request.getSession().setAttribute(SessionAttributeName.ERROR_SET, errorSet.getAllAndClear());
                    String prevPage = getPreviousPage(request);
                    PagePath pagePath = Arrays.stream(PagePath.values())
                            .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(PagePath.PERSONAL_ACCOUNT);
                    page = pagePath.getServletCommand();
                } else {
                    page = PagePath.ERROR_404.getDirectUrl();
                }
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
