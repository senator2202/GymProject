package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.RequestParameterName;
import com.kharitonov.gym.controller.command.ServletPath;
import com.kharitonov.gym.controller.command.SessionAttributeName;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.service.UserService;
import com.kharitonov.gym.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class MakeDepositCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(MakeDepositCommand.class);
    private final UserService service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        Client client = (Client) request.getSession().getAttribute(SessionAttributeName.USER);
        int id = client.getAccount().getId();
        String amount = request.getParameter(RequestParameterName.AMOUNT);
        try {
            if (service.addToBalance(id, amount)) {
                double balance = client.getMoneyBalance();
                int intAmount = Integer.parseInt(amount);
                client.setMoneyBalance(balance + intAmount);
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
        }
        return ServletPath.PERSONAL_FINANCE;
    }
}
