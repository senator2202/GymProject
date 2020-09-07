package com.kharitonov.gym.model.entity;

import java.util.List;

public class User implements UserFunctionality {
    protected Account account;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    protected User() {
    }

    public Account getAccount() {
        return account;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static class UserBuilder {
        private Account account;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private List<Training> plannedTrainings;

        private UserBuilder() {
        }

        public static UserBuilder aUser() {
            return new UserBuilder();
        }

        public UserBuilder withAccount(Account account) {
            this.account = account;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder withPlannedTrainings(List<Training> plannedTrainings) {
            this.plannedTrainings = plannedTrainings;
            return this;
        }

        public User build() {
            User user = new User();
            user.setAccount(account);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNumber);
            return user;
        }
    }

    @Override
    public void updateUserInfo(User user) {

    }
}
