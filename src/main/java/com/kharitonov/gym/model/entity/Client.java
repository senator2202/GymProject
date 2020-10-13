package com.kharitonov.gym.model.entity;

public class Client extends User {
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
}
