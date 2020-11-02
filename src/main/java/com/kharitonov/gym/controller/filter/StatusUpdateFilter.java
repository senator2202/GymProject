package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.ActiveUsersMap;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.util.SessionAttributeName;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class StatusUpdateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        if (user != null && user.getAccount().getRole() != UserRole.ADMIN) {
            ActiveUsersMap map = ActiveUsersMap.getInstance();
            int id = user.getAccount().getId();
            boolean flag = map.get(id);
            user.getAccount().setIsActive(flag);
        }
        chain.doFilter(request, response);
    }
}
