package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.service.UserService;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class MakeDepositCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(MakeDepositCommand.class);
    private final UserService service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        String amount = request.getParameter(RequestParameterName.AMOUNT);
        String page;
        try {
            if (service.addToBalance(client, amount)) {
                page = ProjectPage.PERSONAL_FINANCE.getServletCommand();
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
