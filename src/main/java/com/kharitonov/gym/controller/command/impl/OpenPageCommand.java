package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class OpenPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return request.getParameter(RequestParameter.PAGE_PATH);
    }
}
