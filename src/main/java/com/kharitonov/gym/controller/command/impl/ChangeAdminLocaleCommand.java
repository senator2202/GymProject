package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.controller.command.SessionAttributeValue;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public class ChangeAdminLocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        String page;
        String oldLocale = user.getAccount().getLocale().getPostfix();
        String newLocale = oldLocale.equals(SessionAttributeValue.EN_LOCALE)
                ? SessionAttributeValue.RU_LOCALE
                : SessionAttributeValue.EN_LOCALE;
        restoreRequestAttributes(request);
        user.getAccount().setLocale(Account.AccountLocale.localeByPostfix(newLocale));
        page = (String) request.getSession().getAttribute(SessionAttributeName.PREVIOUS_PAGE);
        return page;
    }
}
