package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;

import javax.servlet.http.HttpServletRequest;

public class OpenContactsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return PagePath.CONTACTS.getDirectUrl();
    }
}
