package com.kharitonov.gym.util.mail;

import com.kharitonov.gym.exception.ServiceException;
import org.testng.annotations.Test;

public class MailUtilityTest {
    private final MailUtility service = MailUtility.getInstance();

    @Test
    public void testSendConfirmMessage() throws ServiceException {
        service.sendConfirmMessage("senator220291@gmail.com", 243);
    }
}