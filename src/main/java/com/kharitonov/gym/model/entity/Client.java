package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.builder.AccountBuilder;

public class Client extends User {
    private double moneyBalance;
    private double personalDiscount;
    private int boughtTrainings;

    public Client() {
        account = AccountBuilder.anAccount().build();
        account.setRole(UserRole.CLIENT);
    }

    public Client(Account account) {
        account.setRole(UserRole.CLIENT);
        this.account = account;
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

    public int getBoughtTrainings() {
        return boughtTrainings;
    }

    public void setBoughtTrainings(int boughtTrainings) {
        this.boughtTrainings = boughtTrainings;
    }
}
