package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.entity.functionality.UserFunctionality;


public abstract class User implements UserFunctionality {
    protected Account account;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    protected User() {

    }

    protected User(Account account, String firstName,
                   String lastName, String phoneNumber) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
