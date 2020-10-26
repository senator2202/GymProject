package com.kharitonov.gym.controller.command;

public enum ProjectPage {
    ABOUT("/jsp/about.jsp", "/mainController?command=open_about"),
    ADMIN_FEEDBACKS("/jsp/admin_feedbacks.jsp", "/mainController?command=open_admin_feedbacks"),
    ADMIN_MAIN("/jsp/admin_main.jsp", "/mainController?command=open_admin_main"),
    ADMIN_REGISTRATIONS("/jsp/admin_registrations.jsp", "/mainController?command=open_admin_registrations"),
    CONTACTS("/jsp/contacts.jsp", "/mainController?command=open_contacts"),
    ERROR_404("/jsp/error_404.jsp", "/mainController?command=invalid"),
    ERROR_500("/jsp/error_500.jsp", ""),
    HOME("/jsp/home.jsp", "/mainController?command=open_home"),
    INDEX("/index.jsp", "/mainController?command=open_home"),
    PERSONAL_ACCOUNT("/jsp/personal_account.jsp", "/mainController?command=open_personal_account"),
    PERSONAL_DATA("/jsp/personal_data.jsp", "/mainController?command=open_personal_data"),
    PERSONAL_FINANCE("/jsp/personal_finance.jsp", "/mainController?command=open_personal_finance"),
    SCHEDULE("/jsp/schedule.jsp", "/mainController?command=open_schedule");

    private String directUrl;
    private String servletCommand;

    ProjectPage(String directUrl, String servletCommand) {
        this.directUrl = directUrl;
        this.servletCommand = servletCommand;
    }

    public String getDirectUrl() {
        return directUrl;
    }

    public String getServletCommand() {
        return servletCommand;
    }
}
