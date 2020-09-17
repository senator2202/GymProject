package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.entity.functionality.AdminFunctionality;

public class Admin extends User implements AdminFunctionality {
    public Admin() {
        account = Account.AccountBuilder.anAccount().build();
        account.setRole(UserRole.ADMIN);
    }

    public Admin(Account account) {
        account.setRole(UserRole.ADMIN);
        this.account = account;
    }

    @Override
    public void addTrainer() {
        //empty now
    }

    @Override
    public void deleteTrainer() {
        //empty now
    }
}
