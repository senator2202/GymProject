package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.exception.ServiceException;
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
                String email = optional.get();
                request.setAttribute(RequestAttributeName.CONFIRMED_ACCOUNT, email);
            }
            page = PagePath.INDEX;
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR;
        }
        return page;
    }
}
