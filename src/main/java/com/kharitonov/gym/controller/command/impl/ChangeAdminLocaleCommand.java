package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.util.SessionAttributeName;
import com.kharitonov.gym.util.SessionAttributeValue;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

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
        ProjectPage page = Arrays.stream(ProjectPage.values())
                .filter(p -> p.getDirectUrl().equals(prevPage)).findFirst().orElse(ProjectPage.ADMIN_MAIN);
        return page.getServletCommand();
    }
}
