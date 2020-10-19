package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.NavigationPath;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdatePersonalInfoCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdatePersonalInfoCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        int id = user.getAccount().getId();
        String firstName = request.getParameter(RequestParameterName.FIRST_NAME);
        String lastName = request.getParameter(RequestParameterName.LAST_NAME);
        String phone = request.getParameter(RequestParameterName.PHONE);
        String email = request.getParameter(RequestParameterName.EMAIL);
        String localeName = request.getParameter(RequestParameterName.LOCALE) == null
                ? user.getAccount().getLocale().name()
                : request.getParameter(RequestParameterName.LOCALE).toUpperCase();
        Account.AccountLocale locale = Account.AccountLocale.valueOf(localeName);
        String page;
        try {
            service.updateUserInfo(firstName, lastName, phone, email, localeName, id);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phone);
            user.getAccount().setEmail(email);
            user.getAccount().setLocale(locale);
            page = NavigationPath.PERSONAL_PROFILE;
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = NavigationPath.ERROR;
        }
        return page;
    }
}
