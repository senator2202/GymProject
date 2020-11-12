package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.UserRole;

import java.sql.Date;

/**
 * The type Account builder.
 */
public final class AccountBuilder {
    private final Account account;

    private AccountBuilder() {
        account = new Account();
    }

    /**
     * An account account builder.
     *
     * @return the account builder
     */
    public static AccountBuilder anAccount() {
        return new AccountBuilder();
    }

    /**
     * With id account builder.
     *
     * @param id the id
     * @return the account builder
     */
    public AccountBuilder withId(int id) {
        account.setId(id);
        return this;
    }

    /**
     * With name account builder.
     *
     * @param name the name
     * @return the account builder
     */
    public AccountBuilder withName(String name) {
        account.setName(name);
        return this;
    }

    /**
     * With email account builder.
     *
     * @param email the email
     * @return the account builder
     */
    public AccountBuilder withEmail(String email) {
        account.setEmail(email);
        return this;
    }

    /**
     * With role account builder.
     *
     * @param role the role
     * @return the account builder
     */
    public AccountBuilder withRole(UserRole role) {
        account.setRole(role);
        return this;
    }

    /**
     * With registration date account builder.
     *
     * @param registrationDate the registration date
     * @return the account builder
     */
    public AccountBuilder withRegistrationDate(Date registrationDate) {
        account.setRegistrationDate(registrationDate);
        return this;
    }

    /**
     * With is active account builder.
     *
     * @param isActive the is active
     * @return the account builder
     */
    public AccountBuilder withIsActive(boolean isActive) {
        account.setIsActive(isActive);
        return this;
    }

    /**
     * With locale account builder.
     *
     * @param locale the locale
     * @return the account builder
     */
    public AccountBuilder withLocale(Account.AccountLocale locale) {
        account.setLocale(locale);
        return this;
    }

    /**
     * Build account.
     *
     * @return the account
     */
    public Account build() {
        return account;
    }
}
