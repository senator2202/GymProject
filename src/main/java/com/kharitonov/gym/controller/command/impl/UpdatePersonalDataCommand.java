package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.*;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdatePersonalDataCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(UpdatePersonalDataCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttributeName.USER);
        int id = user.getAccount().getId();
        String firstName = request.getParameter(RequestParameterName.FIRST_NAME);
        String lastName = request.getParameter(RequestParameterName.LAST_NAME);
        String phone = request.getParameter(RequestParameterName.PHONE);
        String page;
        try {
            service.updatePersonalData(id, firstName, lastName, phone);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phone);
            page = ServletPath.PERSONAL_DATA;
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_404;
        }
        return page;
    }
}
