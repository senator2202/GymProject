package com.kharitonov.gym.controller.filter;

import com.kharitonov.gym.controller.command.CommandType;
import com.kharitonov.gym.model.entity.UserRole;
import com.kharitonov.gym.validator.FeedbackValidator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CommandRoleMapTest {
    private final CommandRoleMap roleMap = CommandRoleMap.getInstance();

    @Test
    public void testContainsKey() {

        assertTrue(true);
    }
}