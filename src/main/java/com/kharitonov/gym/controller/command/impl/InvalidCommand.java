package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.ProjectPage;
import com.kharitonov.gym.util.RequestParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class InvalidCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(InvalidCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter(RequestParameterName.COMMAND);
        LOGGER.error("Command '{}' is not defined!", command);
        return ProjectPage.ERROR_404.getDirectUrl();
    }
}
