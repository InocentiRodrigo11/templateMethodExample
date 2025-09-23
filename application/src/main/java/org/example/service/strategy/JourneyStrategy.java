package org.example.service.strategy;

public interface JourneyStrategy {
    void execute(Object journey);

    Boolean isApplicable(String journey);
}
