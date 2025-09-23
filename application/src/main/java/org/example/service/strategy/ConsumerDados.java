package org.example.service.strategy;

import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.example.service.chain.handlers.ConsumerDadosHandler;
import org.example.service.chain.handlers.ConsumerFraudesHandler;
import org.example.service.chain.handlers.ConsumerOcrHandler;

public class ConsumerDados implements JourneyStrategy{

    private static final String JOURNEY = "CONSUMER_DADOS";
    private final JourneyHandler journeyHandler;

    public ConsumerDados(ConsumerOcrHandler consumerOcrHandler, ConsumerDadosHandler consumerDadosHandler, ConsumerFraudesHandler consumerFraudesHandler) {
        this.journeyHandler = consumerOcrHandler;
        consumerOcrHandler.setNextHandler(consumerFraudesHandler)
                .setNextHandler(consumerDadosHandler);
    }


    @Override
    public void execute(Object journey) {
        journeyHandler.processar(new JourneyContext(false, "dados"));

    }

    @Override
    public Boolean isApplicable(String journey) {
        return journey.equalsIgnoreCase(JOURNEY);
    }
}
