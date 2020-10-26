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
        String stringId = request.getParameter(RequestParameterName.ID);
        String page;
        int id = Integer.parseInt(stringId);
        try {
            Optional<String> optional;
            service.confirmAccount(id);
            optional = service.findEmailById(id);
            if (optional.isPresent()) {
                User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
                String email = optional.get();
                request.setAttribute(RequestAttributeName.CONFIRMED_ACCOUNT, email);
                if (user!=null) {
                    user.getAccount().setIsActive(true);
                }
            }
            page = ProjectPage.INDEX.getDirectUrl();
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = ProjectPage.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
