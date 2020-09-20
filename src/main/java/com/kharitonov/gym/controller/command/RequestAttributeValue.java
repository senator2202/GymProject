package com.kharitonov.gym.controller.command;

public class RequestAttributeValue {
    public static final String LOGIN_ERROR = "Incorrect login or password!";
    public static final String LOGIN_SUCCESS = "Success login!";
    public static final String REGISTER_SUCCESS = "Registered successfully!\n" +
            "The confirmation link was sent to your email!";
    public static final String CONFIRM_SUCCESS =
            "Your account is successfully confirmed!";
    public static final String CONFIRM_ERROR =
            "Account confirm error!";
    public static final String PERSONAL_ACCOUNT = "Personal Account";

    private RequestAttributeValue() {
    }
}
