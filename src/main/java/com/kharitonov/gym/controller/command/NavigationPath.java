package com.kharitonov.gym.controller.command;

public class NavigationPath {
    public static final String INDEX = "/index.jsp";
    public static final String LOGIN = "/jsp/login.jsp";
    public static final String ERROR = "/jsp/error.jsp";
    public static final String REGISTRATION_SUCCESS = "/jsp/registration_success.jsp";
    public static final String CONFIRM_RESULT = "/jsp/confirm_account_result.jsp";
    public static final String PERSONAL_PROFILE = "/jsp/personal_profile.jsp";
    public static final String SCHEDULE = "/jsp/schedule.jsp";
    public static final String ADMIN_MAIN = "/jsp/admin_main.jsp";
    public static final String ADMIN_REGISTRATIONS = "/jsp/admin_registrations.jsp";
    public static final String ADMIN_FEEDBACKS = "/jsp/admin_feedbacks.jsp";
    public static final String HOME = "/jsp/home.jsp";
    public static final String OPEN_SCHEDULE = "/mainController?command=open_schedule";
    public static final String OPEN_ADMIN_MAIN = "/mainController?command=open_admin_main";
    public static final String OPEN_PERSONAL_PROFILE = "/mainController?command=open_page&page=personal_profile";
    public static final String LOGIN_INDEX = "/index.jsp#popupLogin";
    public static final String PERSONAL_DATA = "/jsp/personal_data.jsp";
    public static final String PERSONAL_ACCOUNT = "/jsp/personal_account.jsp";
    public static final String PERSONAL_FINANCE = "/jsp/personal_finance.jsp";

    private NavigationPath() {
    }
}
