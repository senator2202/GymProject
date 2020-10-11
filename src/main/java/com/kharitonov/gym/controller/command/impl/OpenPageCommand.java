package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestParameter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class OpenPageCommand implements ActionCommand {
    private final Map<String, String> pageMap;

    {
        pageMap = new HashMap<>();
        pageMap.put("login", PagePath.LOGIN);
        pageMap.put("personal_profile", PagePath.PERSONAL_PROFILE);
        pageMap.put("admin_main", PagePath.ADMIN_MAIN);
        pageMap.put("schedule", PagePath.SCHEDULE);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter(RequestParameter.PAGE);
        return pageMap.containsKey(page) ? pageMap.get(page) : PagePath.ERROR;
    }
}
