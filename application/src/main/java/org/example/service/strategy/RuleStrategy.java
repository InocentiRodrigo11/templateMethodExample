package org.example.service.strategy;

public interface RuleStrategy {

    void send(Object rule);

    Boolean isApplicable(Object rule);
}
