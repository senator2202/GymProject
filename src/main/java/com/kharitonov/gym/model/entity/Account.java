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

}
