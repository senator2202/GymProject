package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class Account {
    private int id;
    private String name;
    private String password;
    private UserRole type;
    private Date registrationDate;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getType() {
        return type;
    }

    public void setType(UserRole type) {
        this.type = type;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static final class AccountBuilder {
        private int id;
        private String name;
        private String password;
        private UserRole type;
        private Date registrationDate;

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

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder withType(UserRole type) {
            this.type = type;
            return this;
        }

        public AccountBuilder withRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setName(name);
            account.setPassword(password);
            account.setType(type);
            account.setRegistrationDate(registrationDate);
            return account;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (name != null ? !name.equals(account.name) : account.name != null)
            return false;
        if (password != null ? !password.equals(account.password) : account.password != null)
            return false;
        if (type != account.type) return false;
        return registrationDate != null ? registrationDate.equals(account.registrationDate) : account.registrationDate == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        return result;
    }
}
