package org.example.controller;

import org.example.service.EmailNotificationService;
import org.example.service.SmsNotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @GetMapping("/notify/email")
    public String notifyEmail() {
        new EmailNotificationService().sendNotification("usuario@email.com", "Bem-vindo!");
        return "Notificação por e-mail enviada!";
    }

    @GetMapping("/notify/sms")
    public String notifySms() {
        new SmsNotificationService().sendNotification("11999999999", "Seu código é 1234");
        return "Notificação por SMS enviada!";
    }
}