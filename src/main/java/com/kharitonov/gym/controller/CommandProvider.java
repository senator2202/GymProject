package com.kharitonov.gym.controller;

import com.kharitonov.gym.controller.command.ActionCommand;
import com.kharitonov.gym.controller.command.CommandType;
import com.kharitonov.gym.controller.command.impl.InvalidCommand;

/**
 * Defines command by its string value
 */
public class CommandProvider {
    private CommandProvider() {
    }

    /**
     * Define command action command.
     *
     * @param command the command
     * @return the action command
     */
    public static ActionCommand defineCommand(String command) {
        ActionCommand actionCommand;
        try {
            actionCommand = CommandType.valueOf(command.toUpperCase()).getCommand();
        } catch (IllegalArgumentException e) {
            actionCommand = new InvalidCommand();
        }
        return actionCommand;
    }

    /**
     * Define command type command type.
     *
     * @param command the command
     * @return the command type
     */
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
