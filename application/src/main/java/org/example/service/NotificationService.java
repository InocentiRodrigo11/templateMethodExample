package org.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);


    public void sendNotification(String to, String message) {

        validate(to,message);
        String formttedMessage = formatMessage(message);
        doSend(to,formttedMessage);
        log(to, formttedMessage);
    }

    protected void validate(String to, String message) {

        if(to==null || to.isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty");
        }

    }

    protected String formatMessage(String message) {

        return message.trim();

    }

    protected abstract void doSend(String to, String message);

    protected void log(String to, String message) {

        logger.info("Notification sent to {}: {}", to, message);

    }
}
