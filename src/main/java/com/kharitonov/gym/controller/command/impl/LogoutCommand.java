package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.ActiveUsersMap;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.util.SessionAttributeName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * This command allows the user to logout
 */
public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        if (user != null) {
            ActiveUsersMap map = ActiveUsersMap.getInstance();
            map.remove(user.getAccount().getId());
        }
        session.invalidate();
        return PagePath.INDEX.getDirectUrl();
    }
}
