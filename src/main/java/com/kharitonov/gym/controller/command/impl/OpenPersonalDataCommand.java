package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.NavigationPath;
import com.kharitonov.gym.controller.command.RequestAttributeName;
import com.kharitonov.gym.controller.command.RequestAttributeValue;

import javax.servlet.http.HttpServletRequest;

public class OpenPersonalDataCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.PERSONAL_DATA_TAB);
        return NavigationPath.PERSONAL_DATA;
    }
}
