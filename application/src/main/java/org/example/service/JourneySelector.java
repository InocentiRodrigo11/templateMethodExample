package org.example.service;

import org.example.service.strategy.JourneyStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JourneySelector {

    private final List<JourneyStrategy> strategies;

    public JourneySelector(List<JourneyStrategy> strategies) {
        this.strategies = strategies;
    }

    public void execute(String journey, Object data) {

        strategies.stream()
                  .filter(strategy -> strategy.isApplicable(journey))
                  .findFirst()
                  .ifPresent(strategy -> strategy.execute(data));

    }
}
