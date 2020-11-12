package com.kharitonov.gym.model.builder;

import com.kharitonov.gym.model.entity.Client;

public final class ClientBuilder extends UserBuilder<ClientBuilder> {
    private ClientBuilder() {
        user = new Client();
    }

    public static ClientBuilder aClient() {
        return new ClientBuilder();
    }

    @Override
    public Client build() {
        return (Client) user;
    }

    public ClientBuilder withMoneyBalance(double moneyBalance) {
        ((Client) user).setMoneyBalance(moneyBalance);
        return this;
    }

    public ClientBuilder withPersonalDiscount(double personalDiscount) {
        ((Client) user).setPersonalDiscount(personalDiscount);
        return this;
    }

    public ClientBuilder withBoughtTrainings(int boughtTrainings) {
        ((Client) user).setBoughtTrainings(boughtTrainings);
        return this;
    }
}
