package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Trainer;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class UpdateShortSummaryCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdateShortSummaryCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Trainer trainer = (Trainer) request.getSession().getAttribute(SessionAttributeName.USER);
        int id = trainer.getAccount().getId();
        String summary = request.getParameter(RequestParameterName.SHORT_SUMMARY);
        String page;
        try {
            if (service.updateShortSummary(id, summary)) {
                trainer.setShortSummary(summary);
                String prevPage = getPreviousPage(request);
                PagePath pagePath = Arrays.stream(PagePath.values())
                        .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(PagePath.PERSONAL_ACCOUNT);
                page = pagePath.getServletCommand();
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
