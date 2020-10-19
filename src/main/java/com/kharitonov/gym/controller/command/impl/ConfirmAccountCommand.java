package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ConfirmAccountCommand implements ActionCommand {
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String stringId = request.getParameter(RequestParameterName.ID);
        int id = Integer.parseInt(stringId);
        try {
            service.confirmAccount(id);
            request.setAttribute(RequestAttributeName.CONFIRM_ACCOUNT_RESULT,
                    RequestAttributeValue.CONFIRM_SUCCESS);
        } catch (ServiceException e) {
            request.setAttribute(RequestAttributeName.CONFIRM_ACCOUNT_RESULT,
                    RequestAttributeValue.CONFIRM_ERROR);
        }
        return NavigationPath.CONFIRM_RESULT;
    }
}
