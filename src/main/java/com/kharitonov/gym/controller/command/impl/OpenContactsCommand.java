package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.NavigationPath;

import javax.servlet.http.HttpServletRequest;

public class OpenContactsCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return NavigationPath.CONTACTS;
    }
}
