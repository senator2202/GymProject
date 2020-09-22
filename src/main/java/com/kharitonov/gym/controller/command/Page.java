package com.kharitonov.gym.controller.command;

public enum Page {
    PERSONAL_PROFILE("personal_profile","/jsp/personal_profile.jsp"),
    LOGIN("login","/jsp/login.jsp"),
    ERROR("error", "/jsp/error.jsp");

    private String name;
    private String path;

    Page(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
