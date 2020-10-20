package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.NavigationPath;
import com.kharitonov.gym.controller.command.RequestParameterName;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class OpenPageCommand implements ActionCommand {
    private final Map<String, String> pageMap;

    {
        pageMap = new HashMap<>();
        pageMap.put("login", NavigationPath.LOGIN);
        pageMap.put("personal_profile", NavigationPath.PERSONAL_PROFILE);
        pageMap.put("admin_main", NavigationPath.ADMIN_MAIN);
        pageMap.put("schedule", NavigationPath.SCHEDULE);
        pageMap.put("home", NavigationPath.HOME);
        pageMap.put("personal_data", NavigationPath.PERSONAL_DATA);
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter(RequestParameterName.PAGE);
        return pageMap.containsKey(page) ? pageMap.get(page) : NavigationPath.INDEX;
    }
}
