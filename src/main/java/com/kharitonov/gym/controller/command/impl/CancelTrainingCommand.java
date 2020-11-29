package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.exception.ServiceException;
import com.kharitonov.gym.model.entity.Client;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.service.TrainingService;
import com.kharitonov.gym.model.service.impl.TrainingServiceImpl;
import com.kharitonov.gym.util.RequestParameterName;
import com.kharitonov.gym.util.SessionAttributeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * This command allows the user to cancel his training
 */
public class CancelTrainingCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(CancelTrainingCommand.class);
    private final TrainingService service = TrainingServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionAttributeName.USER);
        String clientId = request.getParameter(RequestParameterName.CLIENT_ID);
        String trainingId = request.getParameter(RequestParameterName.TRAINING_ID);
        String page;
        try {
            if (service.deleteTraining(trainingId, clientId)) {
                if (user instanceof Client) {
                    Client client = (Client) user;
                    ((Client) user).setBoughtTrainings(client.getBoughtTrainings() + 1);
                }
                page = PagePath.SCHEDULE.getServletPath();
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
