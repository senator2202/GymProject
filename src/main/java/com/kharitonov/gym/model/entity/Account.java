package com.kharitonov.gym.model.entity;

import java.sql.Date;

/**
 * The type Account.
 */
public class Account {
    private int id;
    private String name;
    private String email;
    private UserRole role;
    private Date registrationDate;
    private boolean isActive;
    private AccountLocale locale;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Gets registration date.
     *
     * @return the registration date
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets registration date.
     *
     * @param registrationDate the registration date
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Gets is active.
     *
     * @return the is active
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Sets is active.
     *
     * @param isActive the is active
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets locale.
     *
     * @return the locale
     */
    public AccountLocale getLocale() {
        return locale;
    }

    /**
     * Sets locale.
     *
     * @param locale the locale
     */
    public void setLocale(AccountLocale locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (id != account.id) {
            return false;
        }
        if (isActive != account.isActive) {
            return false;
        }
        if (name != null ? !name.equals(account.name) : account.name != null) {
            return false;
        }
        if (email != null ? !email.equals(account.email) : account.email != null) {
            return false;
        }
        if (role != account.role) {
            return false;
        }
        if (registrationDate != null
                ? !registrationDate.equals(account.registrationDate)
                : account.registrationDate != null) {
            return false;
        }
        return locale == account.locale;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", role=").append(role);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", isActive=").append(isActive);
        sb.append(", locale=").append(locale);
        sb.append('}');
        return sb.toString();
    }

    /**
     * The enum Account locale.
     */
    public enum AccountLocale {
        /**
         * Russian account locale.
         */
        RUSSIAN("ru"),
        /**
         * English account locale.
         */
        ENGLISH("en");

        private final String postfix;

        AccountLocale(String postfix) {
            this.postfix = postfix;
        }

        /**
         * Locale by postfix account locale.
         *
         * @param postfix the postfix
         * @return the account locale
         */
        public static AccountLocale localeByPostfix(String postfix) {
            for (AccountLocale value : values()) {
                if (value.postfix.equals(postfix)) {
                    return value;
                }
            }
            return null;
        }

        /**
         * Gets postfix.
         *
         * @return the postfix
         */
        public String getPostfix() {
            return postfix;
        }
    }
}
