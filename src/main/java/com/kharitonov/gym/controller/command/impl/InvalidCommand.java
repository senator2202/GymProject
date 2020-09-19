package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class InvalidCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.ERROR;
    }
}
