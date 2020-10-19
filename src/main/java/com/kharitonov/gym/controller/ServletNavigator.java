package com.kharitonov.gym.controller;

import com.kharitonov.gym.controller.command.PagePath;

import java.util.HashMap;
import java.util.Map;

class ServletNavigator {
    private static Map<String, String> navigationMap;

    static {
        navigationMap = new HashMap<>();
        navigationMap.put(PagePath.SCHEDULE, "/mainController?command=open_schedule");
        navigationMap.put(PagePath.INDEX, "/index.jsp");
        navigationMap.put(PagePath.ADMIN_MAIN, "/mainController?command=open_admin_main");
        navigationMap.put(PagePath.PERSONAL_PROFILE, "/mainController?command=open_page&page=personal_profile");
        navigationMap.put(PagePath.HOME, "/jsp/home.jsp");
        navigationMap.put(PagePath.ADMIN_MAIN, "/mainController?command=open_admin_main");
    }

    static String get(Object key) {
        return navigationMap.get(key);
    }
}
