package com.kharitonov.gym.model.entity.impl;

import com.kharitonov.gym.model.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer extends User implements TrainerFunctionality, SportFunctionality {
    private List<Training> plannedTrainings;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public void planTraining(Training training) {
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
}
