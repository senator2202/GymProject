package com.kharitonov.gym.model.entity;

public class Admin extends User {
    public Admin() {
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.ADMIN);
    }

    public Admin(Account account) {
        account.setRole(UserRole.ADMIN);
        this.account = account;
    }
}
