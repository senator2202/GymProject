package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.command.PagePath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter(urlPatterns = {"/jsp/*"})
public class PageAccessFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(PageAccessFilter.class);
    private static final Set<String> RESTRICTED_PAGES;

    static {
        RESTRICTED_PAGES = new HashSet<>();
        RESTRICTED_PAGES.add(PagePath.HOME.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.SCHEDULE.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.PERSONAL_FINANCE.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.PERSONAL_ACCOUNT.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.PERSONAL_DATA.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.ADMIN_FEEDBACKS.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.ADMIN_MAIN.getDirectUrl());
        RESTRICTED_PAGES.add(PagePath.ADMIN_REGISTRATIONS.getDirectUrl());
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String page = request.getRequestURI();
        if (RESTRICTED_PAGES.contains(page)) {
            LOGGER.warn("Filter interception: attemption of direct access to page '{}'", request.getRequestURI());
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        chain.doFilter(request, response);
    }
}
