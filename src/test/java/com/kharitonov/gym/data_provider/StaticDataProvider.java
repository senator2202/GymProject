package com.kharitonov.gym.data_provider;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

public class StaticDataProvider {
    public static final User USER_CLIENT;
    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String ADMIN_EMAIL = "admin@gmail.com";

    static {
        Account account = Account.AccountBuilder.anAccount()
                .withName("admin")
                .withPassword("admin")
                .withType(UserRole.ADMIN)
                .build();
        USER_CLIENT = User.UserBuilder.aUser()
                .withAccount(account)
                .withEmail("user@yahoo.com")
                .build();
    }
}
