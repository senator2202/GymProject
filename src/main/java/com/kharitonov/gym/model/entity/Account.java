package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class Account {
    private int id;
    private String name;
    private String email;
    private UserRole role;
    private Date registrationDate;
    private boolean isActive;
    private AccountLocale locale;

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

    public AccountLocale getLocale() {
        return locale;
    }

    public void setLocale(AccountLocale locale) {
        this.locale = locale;
    }

    public enum AccountLocale {
        RUSSIAN("ru"), ENGLISH("en");

        private final String postfix;

        AccountLocale(String postfix) {
            this.postfix = postfix;
        }

        public static AccountLocale localeByPostfix(String postfix) {
            for (AccountLocale value : values()) {
                if (value.postfix.equals(postfix)) {
                    return value;
                }
            }
            return null;
        }

        public String getPostfix() {
            return postfix;
        }
    }

    public static final class AccountBuilder {
        private int id;
        private String name;
        private String email;
        private UserRole type;
        private Date registrationDate;
        private boolean isActive;
        private AccountLocale locale;

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

        public AccountBuilder withLocale(AccountLocale locale) {
            this.locale = locale;
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
            account.setLocale(locale);
            return account;
        }
    }

}
