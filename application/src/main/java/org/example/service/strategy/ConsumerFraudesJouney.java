package org.example.service.strategy;

import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.example.service.chain.handlers.ConsumerDadosHandler;
import org.example.service.chain.handlers.ConsumerFraudesHandler;
import org.example.service.chain.handlers.ConsumerOcrHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerFraudesJouney implements JourneyStrategy{

    private static final String JOURNEY = "CONSUMER_FRAUDES";
    private final JourneyHandler journeyHandler;

    public ConsumerFraudesJouney(ConsumerOcrHandler consumerOcrHandler, ConsumerDadosHandler consumerDadosHandler, ConsumerFraudesHandler consumerFraudesHandler) {
        this.journeyHandler = consumerOcrHandler;
        consumerOcrHandler.setNextHandler(consumerFraudesHandler)
                .setNextHandler(consumerDadosHandler);
    }

    public void execute(Object journey) {
        journeyHandler.processar(new JourneyContext(false, "fraudes"));

    }

    public Boolean isApplicable(String journey) {
        return journey.equalsIgnoreCase(JOURNEY);
    }
}
