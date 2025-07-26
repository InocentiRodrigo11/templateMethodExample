package org.example.service.strategy;

import org.example.domain.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RuleEmail implements RuleStrategy {

    private static final Logger logger = LoggerFactory.getLogger(RuleEmail.class);

    @Override
    public void send(Object rule) {
        logger.info("Enviando  para {}", rule);
    }

    @Override
    public Boolean isApplicable(Object rule) {
        return rule instanceof Email;
    }
}
