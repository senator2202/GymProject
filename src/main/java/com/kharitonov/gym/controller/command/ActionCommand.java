package com.kharitonov.gym.controller.command;

import com.kharitonov.gym.controller.RequestAttributesWrapper;
import com.kharitonov.gym.util.SessionAttributeName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The interface Action command.
 */
public interface ActionCommand {

    /**
     * Main abstract method for all commands
     *
     * @param request the http request
     * @return the page where to forward/redirect
     */
    String execute(HttpServletRequest request);

    /**
     * Restore last request attributes from session.
     *
     * @param request the request
     */
    default void restoreRequestAttributes(HttpServletRequest request) {
        RequestAttributesWrapper wrapper =
                (RequestAttributesWrapper) request.getSession().getAttribute(SessionAttributeName.SAVED_ATTRIBUTES);
        Set<Map.Entry<String, Object>> set = wrapper.entrySet();
        for (Map.Entry<String, Object> entry : set) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!key.equals(SessionAttributeName.USER)) {
                request.setAttribute(key, value);
            }
        }
    }

    /**
     * Gets previous page.
     *
     * @param request the request
     * @return the previous page
     */
    default String getPreviousPage(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(SessionAttributeName.PREVIOUS_PAGE);
    }

    /**
     * Clear session attributes except user.
     *
     * @param request the request
     */
    default void clearSessionAttributesExceptUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration<String> attrs = session.getAttributeNames();
        Iterator<String> iterator = attrs.asIterator();
        while (iterator.hasNext()) {
            String attrName = iterator.next();
            if (!attrName.equals(SessionAttributeName.USER)) {
                session.removeAttribute(attrName);
            }
        }
    }
}
