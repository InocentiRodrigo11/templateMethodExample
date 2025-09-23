package org.example.service.strategy;

import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.example.service.chain.handlers.ConsumerDadosHandler;
import org.example.service.chain.handlers.ConsumerFraudesHandler;
import org.example.service.chain.handlers.ConsumerOcrHandler;

public class ConsumerOcrJourney implements JourneyStrategy{

    private static final String JOURNEY = "CONSUMER_OCR";
    private final JourneyHandler journeyHandler;

    public ConsumerOcrJourney(ConsumerOcrHandler consumerOcrHandler, ConsumerDadosHandler consumerDadosHandler, ConsumerFraudesHandler consumerFraudesHandler) {
        this.journeyHandler = consumerOcrHandler;
        consumerOcrHandler.setNextHandler(consumerFraudesHandler)
                .setNextHandler(consumerDadosHandler);
    }

    @Override
    public void execute(Object journey) {
        journeyHandler.processar(new JourneyContext(false, "ocr"));
    }

    @Override
    public Boolean isApplicable(String journey) {
        return journey.equalsIgnoreCase(JOURNEY);
    }
}
