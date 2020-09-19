package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestAttributeValue;
import com.kharitonov.gym.controller.command.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ConfirmAccountCommand implements ActionCommand {
    private final UserServiceImpl service = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String stringId = request.getParameter(RequestParameter.ID);
        int id = Integer.parseInt(stringId);
        try {
            service.confirmAccount(id);
            request.setAttribute(RequestAttributeName.CONFIRM_ACCOUNT_RESULT,
                    RequestAttributeValue.CONFIRM_SUCCESS);
        } catch (ServiceException e) {
            request.setAttribute(RequestAttributeName.CONFIRM_ACCOUNT_RESULT,
                    RequestAttributeValue.CONFIRM_ERROR);
        }
        return PagePath.CONFIRM_RESULT;
    }
}
