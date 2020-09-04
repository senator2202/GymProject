package com.kharitonov.gym.model.entity;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private UserRole type;
    private Date registrationDate;

    protected User() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getType() {
        return type;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setType(UserRole type) {
        this.type = type;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public static class UserBuilder {
        private int id;
        private String name;
        private String password;
        private String email;
        private UserRole type;
        private Date registrationDate;

        private UserBuilder() {
        }

        public static UserBuilder aUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withType(UserRole type) {
            this.type = type;
            return this;
        }

        public UserBuilder withRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setPassword(password);
            user.setEmail(email);
            user.setType(type);
            user.setRegistrationDate(registrationDate);
            return user;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null)
            return false;
        if (password != null ? !password.equals(user.password) : user.password != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null)
            return false;
        return type == user.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
