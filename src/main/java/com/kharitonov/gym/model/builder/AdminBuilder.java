package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.User;

/**
 * The type Admin builder.
 */
public class AdminBuilder extends UserBuilder<AdminBuilder> {
    private AdminBuilder() {
        user = new User();
    }

    /**
     * An admin admin builder.
     *
     * @return the admin builder
     */
    public static AdminBuilder anAdmin() {
        return new AdminBuilder();
    }

    @Override
    public User build() {
        return user;
    }
}
