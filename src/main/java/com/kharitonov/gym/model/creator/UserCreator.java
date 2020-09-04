package com.kharitonov.gym.model.creator;

import com.kharitonov.gym.model.entity.User;
import com.kharitonov.gym.security.WebCipher;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCreator {
    public static User create(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableColumnName.USER_ID);
        String name = resultSet.getString(TableColumnName.USER_NAME);
        byte[] encryptedBytes = resultSet
                .getBytes(TableColumnName.USER_PASSWORD);
        boolean isAdmin = resultSet.getBoolean(TableColumnName.USER_IS_ADMIN);
        WebCipher cipher = new WebCipher();
        byte[] decryptedBytes = cipher.decryptMessage(encryptedBytes);
        String password = new String(decryptedBytes);
        return new User(id, name, password, isAdmin);
    }

    private UserCreator() {
    }
}
