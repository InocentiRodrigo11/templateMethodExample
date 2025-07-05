package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotificationService extends NotificationService{

    private static final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);


    @Override
    protected void doSend(String to, String message) {
        logger.info("Enviando SMS para {}: {}", to, message);
    }
}
