package com.kharitonov.gym.controller.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This filter denies direct access to some pages
 */
@WebFilter(urlPatterns = {"/jsp/*"})
public class PageAccessFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(PageAccessFilter.class);

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        RestrictedPageSet set = RestrictedPageSet.getInstance();
        String page = request.getRequestURI();
        if (set.contains(page)) {
            LOGGER.warn("Filter interception: attemption of direct access to page '{}'", request.getRequestURI());
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        chain.doFilter(request, response);
    }
}
