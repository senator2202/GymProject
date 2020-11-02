package com.kharitonov.gym.controller;

import java.util.HashMap;

public class ActiveUsersMap extends HashMap<Integer, Boolean> {
    private static final ActiveUsersMap INSTANCE = new ActiveUsersMap();

    private ActiveUsersMap() {
    }

    public static ActiveUsersMap getInstance() {
        return INSTANCE;
    }
}
