package org.example.service.strategy.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyNotificationService {

    private static final Logger logger = LoggerFactory.getLogger(StrategyNotificationService.class);

    private final List<RuleStrategy> ruleStrategies;

    public StrategyNotificationService(List<RuleStrategy> ruleStrategies) {
        this.ruleStrategies = ruleStrategies;
    }

    public void send(Object rule) {

        logger.info("Sending notification for rule: {}", rule);

        ruleStrategies.stream()
                .filter(ruleImp -> ruleImp.isApplicable(rule))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No applicable strategy found for rule: " + rule))
                .send(rule);

        logger.info("Notification sent successfully for rule: {}", rule);
    }
}
