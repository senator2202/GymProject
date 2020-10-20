package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;

import javax.servlet.http.HttpServletRequest;

public class OpenAccountDataCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.PERSONAL_ACCOUNT_TAB);
        return NavigationPath.PERSONAL_ACCOUNT;
    }
}
