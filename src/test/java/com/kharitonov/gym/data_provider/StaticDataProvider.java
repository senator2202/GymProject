package com.kharitonov.gym.data_provider;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.impl.Admin;
import com.kharitonov.gym.service.security.CryptoService;

public class StaticDataProvider {
    public static final Admin USER_ADMIN;
    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String ADMIN_EMAIL = "admin@gmail.com";

    static {
        Account account = Account.AccountBuilder.anAccount()
                .withName(ADMIN_NAME)
                .withEmail(ADMIN_EMAIL)
                .build();
        USER_ADMIN = new Admin(account);
    }
}
