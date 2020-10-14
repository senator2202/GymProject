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
    }

    static String get(Object key) {
        return navigationMap.get(key);
    }
}
