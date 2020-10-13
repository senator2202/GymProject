package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeValue;

import javax.servlet.http.HttpServletRequest;

public class ChangeAdminLocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String oldLocale = (String) request.getSession().getAttribute(SessionAttributeName.ADMIN_LOCALE);
        String newLocale = oldLocale.equals(SessionAttributeValue.EN_LOCALE)
                ? SessionAttributeValue.RU_LOCALE
                : SessionAttributeValue.EN_LOCALE;
        restoreRequestAttributes(request);
        request.getSession().setAttribute(SessionAttributeName.ADMIN_LOCALE, newLocale);
        page = (String) request.getSession().getAttribute(SessionAttributeName.PREVIOUS_PAGE);
        return page;
    }
}
