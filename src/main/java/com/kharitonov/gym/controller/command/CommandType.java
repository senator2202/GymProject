package com.kharitonov.gym.controller.command;

import com.kharitonov.gym.controller.command.impl.InvalidCommand;
import com.kharitonov.gym.controller.command.impl.LoginCommand;
import com.kharitonov.gym.controller.command.impl.LogoutCommand;
import com.kharitonov.gym.controller.command.impl.RegisterCommand;

public enum CommandType {
    LOGIN(new LoginCommand()),
    INVALID(new InvalidCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTER(new RegisterCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
