package org.example.service.chain.handlers;

import org.example.service.BreClient;
import org.example.service.DadosClient;
import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerDadosHandler extends JourneyHandler {

    private final DadosClient dadosClient;

    public ConsumerDadosHandler(DadosClient dadosClient) {
        this.dadosClient = dadosClient;
    }

    @Override
    public void processar(JourneyContext context) {
        System.out.println("Processing Consumer dados Journey");
        if (context.getProcessed() || context.getProcesssing()) {
            context.setJourney("dados");
            super.processar(context);
        }
        dadosClient.evaluate(context.getJourney());
        context.setProcesssing(true);
        context.setProcessed(false);
        context.setJourney("dados");
        super.processar(context);
    }

}
