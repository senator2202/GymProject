package com.kharitonov.gym.model.entity;

import com.kharitonov.gym.model.builder.AccountBuilder;

/**
 * The type Client.
 */
public class Client extends User {
    private double moneyBalance;
    private double personalDiscount;
    private int boughtTrainings;

    /**
     * Instantiates a new Client.
     */
    public Client() {
        account = AccountBuilder.anAccount().build();
        account.setRole(UserRole.CLIENT);
    }

    /**
     * Instantiates a new Client.
     *
     * @param account the account
     */
    public Client(Account account) {
        account.setRole(UserRole.CLIENT);
        this.account = account;
    }

    /**
     * Gets money balance.
     *
     * @return the money balance
     */
    public double getMoneyBalance() {
        return moneyBalance;
    }

    /**
     * Sets money balance.
     *
     * @param moneyBalance the money balance
     */
    public void setMoneyBalance(double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    /**
     * Gets personal discount.
     *
     * @return the personal discount
     */
    public double getPersonalDiscount() {
        return personalDiscount;
    }

    /**
     * Sets personal discount.
     *
     * @param personalDiscount the personal discount
     */
    public void setPersonalDiscount(double personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    /**
     * Gets bought trainings.
     *
     * @return the bought trainings
     */
    public int getBoughtTrainings() {
        return boughtTrainings;
    }

    /**
     * Sets bought trainings.
     *
     * @param boughtTrainings the bought trainings
     */
    public void setBoughtTrainings(int boughtTrainings) {
        this.boughtTrainings = boughtTrainings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Client client = (Client) o;

        if (Double.compare(client.moneyBalance, moneyBalance) != 0) {
            return false;
        }
        if (Double.compare(client.personalDiscount, personalDiscount) != 0) {
            return false;
        }
        if (boughtTrainings != client.boughtTrainings) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(moneyBalance);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(personalDiscount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + boughtTrainings;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("moneyBalance=").append(moneyBalance);
        sb.append(", personalDiscount=").append(personalDiscount);
        sb.append(", boughtTrainings=").append(boughtTrainings);
        sb.append(", account=").append(account);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", imageName='").append(imageName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
