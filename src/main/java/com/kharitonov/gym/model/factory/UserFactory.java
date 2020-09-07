package com.kharitonov.gym.model.factory;

import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.entity.impl.Admin;
import com.kharitonov.gym.model.entity.impl.Client;
import com.kharitonov.gym.model.entity.impl.Trainer;

public class UserFactory {
    public static User createUser(UserRole role) {
        User user;
        switch (role) {
            case ADMIN:
                user = new Admin();
                break;
            case TRAINER:
                user = new Trainer();
                break;
            default:
                user = new Client();
        }
        return user;
    }
}
