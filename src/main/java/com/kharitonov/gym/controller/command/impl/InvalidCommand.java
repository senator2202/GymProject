package com.kharitonov.gym.controller.command.impl;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.PagePath;
import com.kharitonov.gym.util.RequestParameterName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * Any other command that is not defined
 */
public class InvalidCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(InvalidCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        String command = request.getParameter(RequestParameterName.COMMAND);
        LOGGER.error("Command '{}' is not defined!", command);
        return PagePath.ERROR_404.getDirectUrl();
    }
}
