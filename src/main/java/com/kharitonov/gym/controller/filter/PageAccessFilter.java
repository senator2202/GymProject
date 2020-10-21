package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.command.NavigationPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/jsp/*"})
public class PageAccessFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(PageAccessFilter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (!response.isCommitted()) {
            LOGGER.warn("Filter interception: attemption of direct access to page '{}'", request.getRequestURI());
            response.sendRedirect(request.getContextPath() + NavigationPath.INDEX);
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
