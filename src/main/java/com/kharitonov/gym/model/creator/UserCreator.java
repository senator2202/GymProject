package com.kharitonov.gym.model.creator;

import com.kharitonov.gym.model.entity.Account;
import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.model.factory.UserFactory;
import com.kharitonov.gym.service.security.CryptoService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreator {
    private UserCreator() {
    }

    public static User create(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableColumnName.ACCOUNT_ID);
        String name = resultSet.getString(TableColumnName.ACCOUNT_LOGIN);
        String email = resultSet.getString(TableColumnName.ACCOUNT_EMAIL);
        String role = resultSet.getString(TableColumnName.ACCOUNT_ROLE);
        UserRole userRole = UserRole.valueOf(role);
        Date date = resultSet.getDate(TableColumnName.ACCOUNT_REGISTRATION_DATE);
        Account account = Account.AccountBuilder.anAccount()
                .withId(id)
                .withName(name)
                .withEmail(email)
                .withRole(userRole)
                .withRegistrationDate(date)
                .build();
        User user = UserFactory.createUser(userRole);
        user.setAccount(account);
        return user;
    }
}
