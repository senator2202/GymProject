package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.entity.functionality.ClientFunctionality;
import com.kharitonov.gym.model.entity.functionality.SportFunctionality;

import java.util.List;


public class Client extends User implements ClientFunctionality, SportFunctionality {
    private double moneyBalance;
    private double personalDiscount;
    private int dietId;
    private int boughtTrainings;

    public Client() {
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.CLIENT);
    }

    public Client(Account account) {
        account.setRole(UserRole.CLIENT);
        this.account = account;
    }

    public Client(Account account, String firstName,
                  String lastName, String phoneNumber) {
        super(account, firstName, lastName, phoneNumber);
    }

    public double getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(double moneyBalance) {
        this.moneyBalance = moneyBalance;
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

    public int getBoughtTrainings() {
        return boughtTrainings;
    }

    public void setBoughtTrainings(int boughtTrainings) {
        this.boughtTrainings = boughtTrainings;
    }

    @Override
    public void doTraining(Training training) {

    }

    @Override
    public List<Training> allPlannedTrainings() {
        return null;
    }

    @Override
    public void updateUserInfo(User user) {

    }

    @Override
    public void planTraining() {

    }
}
