package com.kharitonov.gym.builder;

import com.kharitonov.gym.model.entity.User;

public class AdminBuilder extends UserBuilder<AdminBuilder> {
    private AdminBuilder() {
        user = new User();
    }

    public static AdminBuilder anAdmin() {
        return new AdminBuilder();
    }

    @Override
    public User build() {
        return user;
    }
}
