package org.example.service.strategy;

import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.example.service.chain.handlers.ConsumerBreHandler;
import org.example.service.chain.handlers.ConsumerDadosHandler;
import org.example.service.chain.handlers.ConsumerFraudesHandler;
import org.example.service.chain.handlers.ConsumerOcrHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerBreJourney implements JourneyStrategy {

    private static final String JOURNEY = "CONSUMER_BRE";
    private final JourneyHandler journeyHandler;

    public ConsumerBreJourney(ConsumerOcrHandler consumerOcrHandler, ConsumerDadosHandler consumerDadosHandler, ConsumerFraudesHandler consumerFraudesHandler, ConsumerBreHandler consumerBreHandler) {
        this.journeyHandler = consumerOcrHandler;
        consumerOcrHandler.setNextHandler(consumerFraudesHandler)
                .setNextHandler(consumerDadosHandler)
                .setNextHandler(consumerBreHandler);
    }

    @Override
    public void execute(Object journey) {
        journeyHandler.processar(new JourneyContext(false, "BRE"));

    }

    @Override
    public Boolean isApplicable(String journey) {
        return journey.equalsIgnoreCase(JOURNEY);
    }
}
