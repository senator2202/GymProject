package com.kharitonov.gym.service.mail;

import com.kharitonov.gym.exception.ServiceException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MailServiceTest {
    private final MailService service = new MailService();

    @Test
    public void testSendConfirmMessage() throws ServiceException {
        service.sendConfirmMessage("senator220291@gmail.com");
    }
}