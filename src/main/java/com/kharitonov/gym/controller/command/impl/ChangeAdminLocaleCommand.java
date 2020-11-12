package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.util.SessionAttributeName;
import com.kharitonov.gym.util.SessionAttributeValue;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * This command allows the admin to change interface language
 */
public class ChangeAdminLocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        String oldLocale = user.getAccount().getLocale().getPostfix();
        String newLocale = oldLocale.equals(SessionAttributeValue.EN_LOCALE)
                ? SessionAttributeValue.RU_LOCALE
                : SessionAttributeValue.EN_LOCALE;
        restoreRequestAttributes(request);
        user.getAccount().setLocale(Account.AccountLocale.localeByPostfix(newLocale));
        String prevPage = getPreviousPage(request);
        PagePath page = Arrays.stream(PagePath.values())
                .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(PagePath.ADMIN_MAIN);
        return page.getServletCommand();
    }
}
