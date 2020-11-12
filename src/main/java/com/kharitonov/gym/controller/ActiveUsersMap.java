package com.kharitonov.gym.controller;

import java.util.HashMap;

/**
 * The Active users map. Key - user id, value - his status.
 * Status could be changed by admin or by executing ConfirmAccountCommand.
 */
public class ActiveUsersMap extends HashMap<Integer, Boolean> {
    private static final ActiveUsersMap INSTANCE = new ActiveUsersMap();

    private ActiveUsersMap() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ActiveUsersMap getInstance() {
        return INSTANCE;
    }
}
