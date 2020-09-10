package com.kharitonov.gym.service.mail;

import com.kharitonov.gym.exception.ServiceException;
import org.testng.annotations.Test;

public class MailServiceTest {
    private final MailService service = MailService.getInstance();

    @Test
    public void testSendConfirmMessage() throws ServiceException {
        service.sendConfirmMessage("senator220291@gmail.com", 243);
    }
}