package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PagePath.INDEX;
    }
}
