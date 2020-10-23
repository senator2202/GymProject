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
import java.util.Map;
import java.util.Set;

@WebFilter(urlPatterns = {"/jsp/*"})
public class PageAccessFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(PageAccessFilter.class);
    private static final Set<String> RESTRICTED_PAGES;

    static {
        RESTRICTED_PAGES = new HashSet<>();
        RESTRICTED_PAGES.add(PagePath.SCHEDULE);
        RESTRICTED_PAGES.add(PagePath.PERSONAL_FINANCE);
        RESTRICTED_PAGES.add(PagePath.PERSONAL_ACCOUNT);
        RESTRICTED_PAGES.add(PagePath.PERSONAL_DATA);
        RESTRICTED_PAGES.add(PagePath.ADMIN_FEEDBACKS);
        RESTRICTED_PAGES.add(PagePath.ADMIN_MAIN);
        RESTRICTED_PAGES.add(PagePath.ADMIN_REGISTRATIONS);
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (!response.isCommitted()) {
            String page = request.getRequestURI();
            if (RESTRICTED_PAGES.contains(page)) {
                LOGGER.warn("Filter interception: attemption of direct access to page '{}'", request.getRequestURI());
                response.sendRedirect(request.getContextPath() + PagePath.INDEX);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(page);
                dispatcher.forward(request, response);
            }
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
