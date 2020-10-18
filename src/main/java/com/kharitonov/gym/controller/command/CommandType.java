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
    OPEN_PAGE(new OpenPageCommand()),
    OPEN_ADMIN_MAIN(new OpenAdminMainCommand()),
    OPEN_ADMIN_REGISTRATIONS(new OpenAdminRegistrationsCommand()),
    OPEN_ADMIN_FEEDBACKS(new OpenAdminFeedbacksCommand()),
    OPEN_SCHEDULE(new OpenScheduleCommand()),
    REFUSE_TRAINER_APPLICATION(new RefuseTrainerApplicationCommand()),
    REGISTER(new RegisterCommand()),
    SEND_TRAINER_APPLICATION(new SendTrainerApplicationCommand()),
    UPDATE_PERSONAL_INFO(new UpdatePersonalInfoCommand()),
    UPLOAD_IMAGE(new UploadImageCommand()),
    UPDATE_TRAINING_DESCRIPTION(new UpdateTrainingDescriptionCommand()),
    ;

    private final ActionCommand command;

    CommandType(ActionCommand command) {
        this.command = command;
    }

    public ActionCommand getCommand() {
        return command;
    }
}
