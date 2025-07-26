package org.example.domain;

public class Email   {

    public Email(String subject, String body, String recipientEmail, String senderEmail) {
        this.subject = subject;
        this.body = body;
        this.recipientEmail = recipientEmail;
        this.senderEmail = senderEmail;
    }

    private String subject;
    private String body;
    private String recipientEmail;
    private String senderEmail;

}
