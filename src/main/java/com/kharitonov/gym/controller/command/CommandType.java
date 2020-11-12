package com.kharitonov.gym.controller.command;

import com.kharitonov.gym.controller.command.impl.*;

/**
 * The enum represents command type.
 */
public enum CommandType {
    ADD_FEEDBACK(new AddFeedbackCommand()),
    ADD_TRAINING(new AddTrainingCommand()),
    APPROVE_TRAINER_APPLICATION(new ApproveTrainerApplicationCommand()),
    BLOCK_USER(new BlockUserCommand()),
    BUY_TRAININGS(new BuyTrainingsCommand()),
    CANCEL_TRAINING(new CancelTrainingCommand()),
    CHANGE_ADMIN_LOCALE(new ChangeAdminLocaleCommand()),
    CONFIRM_ACCOUNT(new ConfirmAccountCommand()),
    INVALID(new InvalidCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    MAKE_DEPOSIT(new MakeDepositCommand()),
    OPEN_ADMIN_FEEDBACKS(new OpenAdminFeedbacksCommand()),
    OPEN_ADMIN_MAIN(new OpenAdminMainCommand()),
    OPEN_ADMIN_REGISTRATIONS(new OpenAdminRegistrationsCommand()),
    OPEN_CONTACTS(new OpenContactsCommand()),
    OPEN_HOME(new OpenHomeCommand()),
    OPEN_PERSONAL_ACCOUNT(new OpenPersonalAccountCommand()),
    OPEN_PERSONAL_DATA(new OpenPersonalDataCommand()),
    OPEN_PERSONAL_FINANCE(new OpenPersonalFinanceCommand()),
    OPEN_SCHEDULE(new OpenScheduleCommand()),
    RATE_TRAINING(new RateTrainingCommand()),
    REFUSE_TRAINER_APPLICATION(new RefuseTrainerApplicationCommand()),
    REGISTER(new RegisterCommand()),
    SEND_FEEDBACK_REPLY(new SendFeedbackReplyCommand()),
    SEND_TRAINER_APPLICATION(new SendTrainerApplicationCommand()),
    SET_TRAINING_DONE(new SetTrainingDoneCommand()),
    UNBLOCK_USER(new UnblockUserCommand()),
    UPDATE_ACCOUNT_DATA(new UpdateAccountDataCommand()),
    UPDATE_DISCOUNT(new UpdateDiscountCommand()),
    UPDATE_PERSONAL_DATA(new UpdatePersonalDataCommand()),
    UPDATE_SHORT_SUMMARY(new UpdateShortSummaryCommand()),
    UPDATE_TRAINING(new UpdateTrainingCommand()),
    UPLOAD_IMAGE(new UploadImageCommand()),
    UPDATE_TRAINING_DESCRIPTION(new UpdateTrainingDescriptionCommand());

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    /**
     * Gets command.
     *
     * @return the command
     */
    public ActionCommand getCommand() {
        return command;
    }
}
