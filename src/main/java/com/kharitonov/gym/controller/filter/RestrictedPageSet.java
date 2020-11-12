package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.command.PagePath;

import java.util.HashSet;

/**
 * Set of page paths, that could not be accessed directly? only by servlet command.
 * Used by PageAccessFilter
 */
public class RestrictedPageSet extends HashSet<String> {
    private static final RestrictedPageSet INSTANCE = new RestrictedPageSet();

    private RestrictedPageSet() {
        add(PagePath.HOME.getDirectUrl());
        add(PagePath.SCHEDULE.getDirectUrl());
        add(PagePath.PERSONAL_FINANCE.getDirectUrl());
        add(PagePath.PERSONAL_ACCOUNT.getDirectUrl());
        add(PagePath.PERSONAL_DATA.getDirectUrl());
        add(PagePath.ADMIN_FEEDBACKS.getDirectUrl());
        add(PagePath.ADMIN_MAIN.getDirectUrl());
        add(PagePath.ADMIN_REGISTRATIONS.getDirectUrl());
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static RestrictedPageSet getInstance() {
        return INSTANCE;
    }
}
