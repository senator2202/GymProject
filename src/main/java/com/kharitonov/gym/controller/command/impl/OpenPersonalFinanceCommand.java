package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.SidebarTabName;

import javax.servlet.http.HttpServletRequest;

/**
 * This command allows the client to open his personal finance page
 */
public class OpenPersonalFinanceCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute(RequestAttributeName.ACTIVE_TAB, SidebarTabName.PERSONAL_FINANCE_TAB);
        return PagePath.PERSONAL_FINANCE.getDirectUrl();
    }
}
