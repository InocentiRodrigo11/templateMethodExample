package org.example.controller;

import org.example.domain.Email;
import org.example.domain.Sms;
import org.example.service.decorator.EmailNotificationService;
import org.example.service.decorator.SmsNotificationService;
import org.example.service.strategy.StrategyNotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    private final StrategyNotificationService strategyNotificationService;

    public NotificationController(StrategyNotificationService strategyNotificationService) {
        this.strategyNotificationService = strategyNotificationService;
    }

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

    @GetMapping("/notify/strategy/sms")
    public String notifySmsStrategy() {

        Sms sms = new Sms("11999999999");

        strategyNotificationService.send(sms);
        return "Notificação por SMS enviada!";
    }

    @GetMapping("/notify/strategy/email")
    public String notifyEmailStrategy() {

        Email email = new Email("teste","teste","teste","teste");
        strategyNotificationService.send(email);
        return "Notificação por Email enviada!";
    }


}