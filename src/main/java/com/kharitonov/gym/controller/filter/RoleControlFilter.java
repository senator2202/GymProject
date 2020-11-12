package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.CommandProvider;
import com.kharitonov.gym.controller.command.CommandType;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This filter controls user access to any commands
 */
@WebFilter(urlPatterns = {"/mainController"})
public class RoleControlFilter implements Filter {
    private static final CommandRoleMap MAP = CommandRoleMap.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(RoleControlFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String command = request.getParameter(RequestParameterName.COMMAND);
        if (command != null) {
            CommandType type = CommandProvider.defineCommandType(command);
            UserRole role = defineUserRole(request);
            if (!MAP.containsRole(type, role)) {
                LOGGER.warn("Filter interception: '{}' attempted to execute '{}' command ", role, command);
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                return;
            }
        } else {
            LOGGER.warn("Filter interception: no command to execute!");
            RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.ERROR_404.getDirectUrl());
            dispatcher.forward(request, response);
        }
        chain.doFilter(request, response);
    }

    private UserRole defineUserRole(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        return (user == null || !user.getAccount().getIsActive())
                ? UserRole.GUEST
                : user.getAccount().getRole();
    }
}
