package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestAttributeValue;

import javax.servlet.http.HttpServletRequest;

/**
 * This command allows the user to open page with his personal data
 */
public class OpenPersonalDataCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestAttributeName.ACTIVE_TAB, RequestAttributeValue.PERSONAL_DATA_TAB);
        return PagePath.PERSONAL_DATA.getDirectUrl();
    }
}
