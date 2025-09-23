package org.example.controller;

import org.example.domain.Email;
import org.example.domain.Sms;
import org.example.service.JourneySelector;
import org.example.service.decorator.EmailNotificationService;
import org.example.service.decorator.SmsNotificationService;
import org.example.service.strategy.example.StrategyNotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuxiliarController {

    private final StrategyNotificationService strategyNotificationService;
    private final JourneySelector journeySelector;

    public AuxiliarController(StrategyNotificationService strategyNotificationService, JourneySelector journeySelector) {
        this.strategyNotificationService = strategyNotificationService;
        this.journeySelector = journeySelector;
    }

    @GetMapping("/auxiliar/executar")
    public String notifyEmail() {
        journeySelector.execute("CONSUMER_BRE", new Object());
        return "Auxiliar executado com sucesso!";
    }

    @PostMapping("/ocr/evaluate")
    public String ocrEvaluate() {
        return "Ocr Evaluate";
    }

    @PostMapping("/bre/evaluate")
    public String breEvaluate() {
        return "Bre Evaluate";
    }

    @PostMapping("/dados/evaluate")
    public String dadosEvaluate() {
        return "Dados Evaluate";
    }

    @PostMapping("/fraudes/evaluate")
    public String fraudesEvaluate() {
        return "Fraudes Evaluate";
    }

}