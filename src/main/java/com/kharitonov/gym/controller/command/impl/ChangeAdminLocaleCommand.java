package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.RequestAttributesWrapper;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeValue;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

public class ChangeAdminLocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String oldLocale = (String) request.getSession().getAttribute(SessionAttributeName.ADMIN_LOCALE);
        String newLocale = oldLocale.equals(SessionAttributeValue.EN_LOCALE)
                ? SessionAttributeValue.RU_LOCALE
                : SessionAttributeValue.EN_LOCALE;
        RequestAttributesWrapper wrapper =
                (RequestAttributesWrapper) request.getSession().getAttribute(SessionAttributeName.SAVED_ATTRIBUTES);
        Set<Map.Entry<String, Object>> set = wrapper.entrySet();
        for (Map.Entry<String, Object> entry : set) {
            String key = entry.getKey();
            Object value = entry.getValue();
            request.setAttribute(key, value);
        }
        request.getSession().setAttribute(SessionAttributeName.ADMIN_LOCALE, newLocale);
        page = (String) request.getSession().getAttribute(SessionAttributeName.PREVIOUS_PAGE);
        return page;
    }
}
