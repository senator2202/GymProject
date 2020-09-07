package com.kharitonov.gym.model.entity.impl;

import com.kharitonov.gym.model.entity.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Client extends User implements ClientFunctionality, SportFunctionality {
    double personalDiscount;
    List<Training> plannedTrainings;

    public Client() {
        plannedTrainings = new ArrayList<>();
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.CLIENT);
    }

    public Client(Account account) {
        plannedTrainings = new ArrayList<>();
        account.setRole(UserRole.CLIENT);
        this.account = account;
    }

    public double getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(double personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    @Override
    public void buyTraining(int trainingId) {
        plannedTrainings.stream().filter(tr -> tr.getTrainingId() == trainingId)
                .findFirst().ifPresent((tr) -> tr.setIsBought(true));
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
