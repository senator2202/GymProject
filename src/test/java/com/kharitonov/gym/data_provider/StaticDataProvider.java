package com.kharitonov.gym.data_provider;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.impl.Admin;
import com.kharitonov.gym.security.WebCipher;

public class StaticDataProvider {
    public static final Admin USER_ADMIN;
    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String ADMIN_EMAIL = "admin@gmail.com";
    public static final byte[] ADMIN_PASSWORD_ENCRYPTED;

    static {
        Account account = Account.AccountBuilder.anAccount()
                .withName(ADMIN_NAME)
                .withPassword(ADMIN_PASSWORD)
                .withEmail(ADMIN_EMAIL)
                .build();
        USER_ADMIN = new Admin(account);
        WebCipher cipher = new WebCipher();
        ADMIN_PASSWORD_ENCRYPTED =
                cipher.encryptMessage(ADMIN_PASSWORD.getBytes());
    }
}
