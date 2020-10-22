package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateAccountDataCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdateAccountDataCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        int id = user.getAccount().getId();
        String email = request.getParameter(RequestParameterName.EMAIL);
        String localeName = request.getParameter(RequestParameterName.LOCALE) == null
                ? user.getAccount().getLocale().name()
                : request.getParameter(RequestParameterName.LOCALE).toUpperCase();
        Account.AccountLocale locale = Account.AccountLocale.valueOf(localeName);
        String page;
        try {
            if (service.updateAccountData(id, email, localeName)) {
                user.getAccount().setEmail(email);
                user.getAccount().setLocale(locale);
            } else {
                session.setAttribute(SessionAttributeName.INCORRECT_EMAIL_FORMAT, true);
            }
            page = ServletPath.PERSONAL_ACCOUNT;
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_404;
        }
        return page;
    }
}
