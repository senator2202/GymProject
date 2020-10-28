package com.kharitonov.gym.controller;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.CommandType;
import com.kharitonov.gym.controller.command.impl.InvalidCommand;

public class CommandProvider {
    private CommandProvider() {
    }

    public static ActionCommand defineCommand(String command) {
        ActionCommand actionCommand;
        try {
            actionCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
        } catch (IllegalArgumentException e) {
            actionCommand = new InvalidCommand();
        }
        return actionCommand;
    }

    public static CommandType defineCommandType(String command) {
        CommandType type;
        try {
            type = CommandType.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
           type = CommandType.INVALID;
        }
        return type;
    }
}
