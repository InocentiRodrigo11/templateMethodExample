package org.example.service.strategy.example;

public interface RuleStrategy {

    void send(Object rule);

    Boolean isApplicable(Object rule);
}
