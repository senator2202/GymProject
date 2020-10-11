package com.kharitonov.gym.model.dao.creator;

import com.kharitonov.gym.model.entity.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreator {
    private UserCreator() {
    }

    public static User create(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableColumnName.ACCOUNT_ID);
        String login = resultSet.getString(TableColumnName.ACCOUNT_LOGIN);
        String email = resultSet.getString(TableColumnName.ACCOUNT_EMAIL);
        String role = resultSet.getString(TableColumnName.ACCOUNT_ROLE);
        UserRole userRole = UserRole.valueOf(role);
        Date date = resultSet.getDate(TableColumnName.ACCOUNT_REGISTRATION_DATE);
        String locale = resultSet.getString(TableColumnName.ACCOUNT_LOCALE);
        Account.AccountLocale accountLocale = Account.AccountLocale.valueOf(locale);
        boolean isActive = resultSet.getBoolean(TableColumnName.ACCOUNT_IS_ACTIVE);
        String firstName = resultSet.getString(TableColumnName.USER_FIRST_NAME);
        String lastName = resultSet.getString(TableColumnName.USER_LAST_NAME);
        String phone = resultSet.getString(TableColumnName.USER_PHONE);
        double discount = resultSet.getDouble(TableColumnName.USER_DISCOUNT);
        double rating = resultSet.getDouble(TableColumnName.USER_RATING);
        int dietId = resultSet.getInt(TableColumnName.USER_DIET_ID);
        String imageName = resultSet.getString(TableColumnName.USER_IMAGE);
        double moneyBalance = resultSet.getDouble(TableColumnName.USER_MONEY_BALANCE);
        int boughtTrainings = resultSet.getInt(TableColumnName.USER_BOUGHT_TRAININGS);
        Account account = Account.AccountBuilder.anAccount()
                .withId(id)
                .withName(login)
                .withEmail(email)
                .withRole(userRole)
                .withRegistrationDate(date)
                .withLocale(accountLocale)
                .withIsActive(isActive)
                .build();
        User user = null;
        if (userRole == UserRole.CLIENT) {
            user = new Client(account, firstName, lastName, phone);
            ((Client) user).setPersonalDiscount(discount);
            ((Client) user).setDietId(dietId);
            ((Client) user).setMoneyBalance(moneyBalance);
            ((Client) user).setBoughtTrainings(boughtTrainings);
        } else if (userRole == UserRole.TRAINER) {
            user = new Trainer(account, firstName, lastName, phone);
            ((Trainer) user).setRating(rating);
        }
        user.setImageName(imageName);
        return user;
    }

}
