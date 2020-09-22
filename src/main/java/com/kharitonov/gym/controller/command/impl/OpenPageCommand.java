package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.controller.command.RequestParameter;
import com.kharitonov.gym.controller.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class OpenPageCommand implements ActionCommand {
    private final Map<String, String> pageMap;

    {
        pageMap = new HashMap<>();
        pageMap.put("login", "/jsp/login.jsp");
        pageMap.put("personal_profile", "/jsp/personal_profile.jsp");
    }

    @Override
    public String execute(HttpServletRequest request) {
        String page = request.getParameter(RequestParameter.PAGE);
        return pageMap.containsKey(page) ? pageMap.get(page) : PagePath.ERROR;
    }
}
