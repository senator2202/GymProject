package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.entity.functionality.SportFunctionality;
import com.kharitonov.gym.model.entity.functionality.TrainerFunctionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer extends User implements TrainerFunctionality, SportFunctionality {
    private List<Training> plannedTrainings;
    private String institution;
    private int graduationYear;
    private String instagramLink;
    private double rating;

    public Trainer() {
        plannedTrainings = new ArrayList<>();
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.TRAINER);
    }

    public Trainer(Account account) {
        plannedTrainings = new ArrayList<>();
        account.setRole(UserRole.TRAINER);
        this.account = account;
    }

    public Trainer(Account account, String firstName,
                   String lastName, String phoneNumber) {
        super(account, firstName, lastName, phoneNumber);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPlannedTrainings(List<Training> plannedTrainings) {
        this.plannedTrainings = plannedTrainings;
    }

    @Override
    public void appointDiet(Training training) {
        plannedTrainings.add(training);
    }

    @Override
    public void doTraining(Training training) {
        plannedTrainings.remove(training);
    }

    @Override
    public List<Training> allPlannedTrainings() {
        return Collections.unmodifiableList(plannedTrainings);
    }

    @Override
    public void updateUserInfo(User user) {

    }

    @Override
    public void planTraining() {

    }
}
