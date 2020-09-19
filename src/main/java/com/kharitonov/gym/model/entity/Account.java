package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class Account {
    private int id;
    private String name;
    private String email;
    private UserRole role;
    private Date registrationDate;
    private boolean isActive;


    private Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public static final class AccountBuilder {
        private int id;
        private String name;
        private String email;
        private UserRole type;
        private Date registrationDate;
        private boolean isActive;

        private AccountBuilder() {
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withRole(UserRole type) {
            this.type = type;
            return this;
        }

        public AccountBuilder withRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public AccountBuilder withIsActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setName(name);
            account.setEmail(email);
            account.setRole(type);
            account.setRegistrationDate(registrationDate);
            account.setIsActive(isActive);
            return account;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (isActive != account.isActive) return false;
        if (name != null ? !name.equals(account.name) : account.name != null)
            return false;
        if (email != null ? !email.equals(account.email) : account.email != null)
            return false;
        if (role != account.role) return false;
        return registrationDate != null
                ? registrationDate.equals(account.registrationDate)
                : account.registrationDate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        return result;
    }
}
