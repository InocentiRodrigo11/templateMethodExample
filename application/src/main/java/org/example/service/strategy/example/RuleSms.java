package org.example.service.strategy.example;

import org.example.domain.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RuleSms implements RuleStrategy {

    private static final Logger logger = LoggerFactory.getLogger(RuleSms.class);


    @Override
    public void send(Object rule) {
        logger.info("Enviando  para {}", rule);
    }

    @Override
    public Boolean isApplicable(Object rule) {
        return rule instanceof Sms;
    }
}
