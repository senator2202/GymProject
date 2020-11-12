package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;

/**
 * The abstract User builder.
 *
 * @param <B> the type parameter
 */
public abstract class UserBuilder<B extends UserBuilder<B>> {
    /**
     * The User.
     */
    protected User user;

    /**
     * Instantiates a new User builder.
     */
    protected UserBuilder() {
    }

    /**
     * With account b.
     *
     * @param account the account
     * @return the b
     */
    public B withAccount(Account account) {
        user.setAccount(account);
        return (B) this;
    }

    /**
     * With first name b.
     *
     * @param firstName the first name
     * @return the b
     */
    public B withFirstName(String firstName) {
        user.setFirstName(firstName);
        return (B) this;
    }

    /**
     * With last name b.
     *
     * @param lastName the last name
     * @return the b
     */
    public B withLastName(String lastName) {
        user.setLastName(lastName);
        return (B) this;
    }

    /**
     * With phone number b.
     *
     * @param phoneNumber the phone number
     * @return the b
     */
    public B withPhoneNumber(String phoneNumber) {
        user.setPhoneNumber(phoneNumber);
        return (B) this;
    }

    /**
     * With image name b.
     *
     * @param imageName the image name
     * @return the b
     */
    public B withImageName(String imageName) {
        user.setImageName(imageName);
        return (B) this;
    }

    /**
     * Build user.
     *
     * @return the user
     */
    public abstract User build();
}
