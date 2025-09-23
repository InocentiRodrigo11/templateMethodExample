package org.example.service.chain.handlers;

import org.example.service.DadosClient;
import org.example.service.FraudesClient;
import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerFraudesHandler extends JourneyHandler {

    private final FraudesClient fraudesClient;

    public ConsumerFraudesHandler(FraudesClient fraudesClient) {
        this.fraudesClient = fraudesClient;
    }


    @Override
    public void processar(JourneyContext context) {
        System.out.println("Processing Consumer Fraudes Journey");
        if (context.getProcessed() || context.getProcesssing()) {
            context.setJourney("fraudes");
            super.processar(context);
        }
        fraudesClient.evaluate(context.getJourney());
        context.setProcesssing(true);
        context.setProcessed(false);
        context.setJourney("fraudes");
        super.processar(context);
    }
}
