package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.ActiveUsersMap;
import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.impl.UserServiceImpl;
import com.kharitonov.gym.util.RequestAttributeName;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * This command allows the user to confirm his account
 */
public class ConfirmAccountCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ConfirmAccountCommand.class);
    private final UserServiceImpl service = UserServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String accountId = request.getParameter(RequestParameterName.ID);
        String page;
        try {
            if (service.confirmAccount(accountId)) {
                int id = Integer.parseInt(accountId);
                Optional<String> optional = service.findEmailById(id);
                if (optional.isPresent()) {
                    User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
                    String email = optional.get();
                    request.setAttribute(RequestAttributeName.CONFIRMED_ACCOUNT, email);
                    ActiveUsersMap map = ActiveUsersMap.getInstance();
                    if (user != null && map.containsKey(id)) {
                        map.put(user.getAccount().getId(), true);
                    }
                }
                page = PagePath.INDEX.getDirectUrl();
            } else {
                page = PagePath.ERROR_404.getDirectUrl();
            }
        } catch (ServiceException e) {
            LOGGER.error(e);
            page = PagePath.ERROR_500.getDirectUrl();
        }
        return page;
    }
}
