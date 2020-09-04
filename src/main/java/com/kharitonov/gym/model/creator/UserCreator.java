package com.kharitonov.gym.model.creator;

import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.security.WebCipher;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreator {
    private UserCreator() {
    }

    public static User create(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableColumnName.USER_ID);
        String name = resultSet.getString(TableColumnName.USER_NAME);
        byte[] encryptedBytes = resultSet
                .getBytes(TableColumnName.USER_PASSWORD);
        String email = resultSet.getString(TableColumnName.USER_EMAIL);
        String role = resultSet.getString(TableColumnName.USER_ROLE);
        UserRole userRole = UserRole.valueOf(role);
        Date date = resultSet.getDate(TableColumnName.USER_REGISTRATION_DATE);
        WebCipher cipher = new WebCipher();
        byte[] decryptedBytes = cipher.decryptMessage(encryptedBytes);
        String password = new String(decryptedBytes);
        return User.UserBuilder.aUser()
                .withId(id)
                .withName(name)
                .withPassword(password)
                .withEmail(email)
                .withType(userRole)
                .withRegistrationDate(date)
                .build();
    }
}
