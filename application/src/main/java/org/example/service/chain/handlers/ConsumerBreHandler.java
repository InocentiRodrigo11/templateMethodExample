package org.example.service.chain.handlers;

import org.example.service.BreClient;
import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerBreHandler extends JourneyHandler {

    private final BreClient breClient;

    public ConsumerBreHandler(BreClient breClient) {
        this.breClient = breClient;
    }

    @Override
    public void processar(JourneyContext context) {
        System.out.println("Processing Consumer bre Journey");
        if (context.getProcessed() || context.getProcesssing()) {
            context.setJourney("bre");
            super.processar(context);
        }

        breClient.evaluate(context.getJourney());

        context.setProcesssing(true);
        context.setProcessed(false);
        context.setJourney("bre");
        super.processar(context);
    }

}
