package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.entity.functionality.ClientFunctionality;
import com.kharitonov.gym.model.entity.functionality.SportFunctionality;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Client extends User implements ClientFunctionality, SportFunctionality {
    private double personalDiscount;
    private int dietId;
    private List<Training> plannedTrainings;

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

    public Client(Account account, String firstName,
                  String lastName, String phoneNumber) {
        super(account, firstName, lastName, phoneNumber);
    }

    public double getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(double personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    public void setPlannedTrainings(List<Training> plannedTrainings) {
        this.plannedTrainings = plannedTrainings;
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
