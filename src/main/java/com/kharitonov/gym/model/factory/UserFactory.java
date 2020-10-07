package com.kharitonov.gym.model.factory;

import com.kharitonov.gym.model.entity.*;

public class UserFactory {
    public static User createUser(UserRole role) {
        User user = null;
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
