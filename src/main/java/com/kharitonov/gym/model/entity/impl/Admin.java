package com.kharitonov.gym.model.entity.impl;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.AdminFunctionality;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;

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

    }

    @Override
    public void deleteTrainer() {

    }
}
