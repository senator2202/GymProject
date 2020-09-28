package com.kharitonov.gym.controller.command;

import com.kharitonov.gym.controller.command.impl.*;

public enum CommandType {
    LOGIN(new LoginCommand()),
    INVALID(new InvalidCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTER(new RegisterCommand()),
    OPEN_PAGE(new OpenPageCommand()),
    CONFIRM_ACCOUNT(new ConfirmAccountCommand()),
    UPDATE_PERSONAL_INFO(new UpdatePersonalInfoCommand()),
    SEND_TRAINER_APPLICATION(new SendTrainerApplicationCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
