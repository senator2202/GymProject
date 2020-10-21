package com.kharitonov.gym.controller.command;

import com.kharitonov.gym.controller.command.impl.*;

public enum CommandType {
    ADD_FEEDBACK(new AddFeedbackCommand()),
    ADD_TRAINING(new AddTrainingCommand()),
    APPROVE_TRAINER_APPLICATION(new ApproveTrainerApplicationCommand()),
    BUY_TRAININGS(new BuyTrainingsCommand()),
    CANCEL_TRAINING(new CancelTrainingCommand()),
    CHANGE_ADMIN_LOCALE(new ChangeAdminLocaleCommand()),
    CONFIRM_ACCOUNT(new ConfirmAccountCommand()),
    INVALID(new InvalidCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    MAKE_DEPOSIT(new MakeDepositCommand()),
    OPEN_ABOUT(new OpenAboutCommand()),
    OPEN_ADMIN_FEEDBACKS(new OpenAdminFeedbacksCommand()),
    OPEN_ADMIN_MAIN(new OpenAdminMainCommand()),
    OPEN_ADMIN_REGISTRATIONS(new OpenAdminRegistrationsCommand()),
    OPEN_CONTACTS(new OpenContactsCommand()),
    OPEN_HOME(new OpenHomeCommand()),
    OPEN_PERSONAL_ACCOUNT(new OpenPersonalAccountCommand()),
    OPEN_PERSONAL_DATA(new OpenPersonalDataCommand()),
    OPEN_PERSONAL_FINANCE(new OpenPersonalFinanceCommand()),
    OPEN_PORTFOLIO(new OpenPortfolioCommand()),
    OPEN_SCHEDULE(new OpenScheduleCommand()),
    REFUSE_TRAINER_APPLICATION(new RefuseTrainerApplicationCommand()),
    REGISTER(new RegisterCommand()),
    SEND_TRAINER_APPLICATION(new SendTrainerApplicationCommand()),
    UPDATE_ACCOUNT_DATA(new UpdateAccountDataCommand()),
    UPDATE_PERSONAL_DATA(new UpdatePersonalDataCommand()),
    UPLOAD_IMAGE(new UploadImageCommand()),
    UPDATE_TRAINING_DESCRIPTION(new UpdateTrainingDescriptionCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
