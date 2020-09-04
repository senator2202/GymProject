package com.kharitonov.gym.data_provider;

import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

public class StaticDataProvider {
    public static final User USER_ADMIN;
    public static final String ADMIN_NAME = "admin";
    public static final String ADMIN_PASSWORD = "admin";
    public static final String ADMIN_EMAIL = "admin@gmail.com";

    static {
        USER_ADMIN = User.UserBuilder.aUser()
                .withName("admin")
                .withPassword("admin")
                .withEmail("admin@gmail.com")
                .withType(UserRole.ADMIN)
                .build();
    }
}
