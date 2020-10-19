package com.kharitonov.gym.controller.command;

import com.kharitonov.gym.controller.RequestAttributesWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

public interface ActionCommand {
    String execute(HttpServletRequest request);

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

    default String getPreviousPage(HttpServletRequest request) {
        return (String) request.getSession().getAttribute(SessionAttributeName.PREVIOUS_PAGE);
    }
}
