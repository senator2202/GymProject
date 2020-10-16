package com.kharitonov.gym.data_provider;

import com.kharitonov.gym.model.entity.Account;

public class StaticDataProvider {
    public static final String ADMIN_LOGIN = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String ADMIN_EMAIL = "admin@gmail.com";
    public static final String CLIENT_LOGIN = "senator2202";
    public static final String CLIENT_PASSWORD = "qwerty1234";
    public static final String CLIENT_EMAIL = "senator220291@gmail.com";
    public static final String CLIENT_PASSWORD_ENCRYPTED = "AAER~MXQ9Vrgph\\g";

    static {
        Account account = Account.AccountBuilder.anAccount()
                .withName(ADMIN_LOGIN)
                .withEmail(ADMIN_EMAIL)
                .build();
    }
}
