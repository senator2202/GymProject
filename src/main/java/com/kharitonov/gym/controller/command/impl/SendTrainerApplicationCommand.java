package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
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
                ProjectPage projectPage = Arrays.stream(ProjectPage.values())
                        .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(ProjectPage.PERSONAL_ACCOUNT);
                page = projectPage.getServletCommand();
            } else {
                ValidationErrorSet errorSet = ValidationErrorSet.getInstance();
                if (errorSet.contains(ValidationError.APPLICATION_EXISTS)) {
                    request.getSession().setAttribute(SessionAttributeName.ERROR_SET, errorSet.getAllAndClear());
                    String prevPage = getPreviousPage(request);
                    ProjectPage projectPage = Arrays.stream(ProjectPage.values())
                            .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(ProjectPage.PERSONAL_ACCOUNT);
                    page = projectPage.getServletCommand();
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
