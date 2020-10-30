package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ConfirmAccountCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ConfirmAccountCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String accountId = request.getParameter(RequestParameterName.ID);
        String page;
        try {
            if (service.confirmAccount(accountId)) {
                int id = Integer.parseInt(accountId);
                Optional<String> optional = service.findEmailById(id);
                if (optional.isPresent()) {
                    User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
                    String email = optional.get();
                    request.setAttribute(RequestAttributeName.CONFIRMED_ACCOUNT, email);
                    if (user != null && user.getAccount().getId() == id) {
                        user.getAccount().setIsActive(true);
                    }
                }
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
