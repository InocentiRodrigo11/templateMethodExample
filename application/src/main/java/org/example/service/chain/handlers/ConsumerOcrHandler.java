package org.example.service.chain.handlers;

import org.example.service.DadosClient;
import org.example.service.OcrClient;
import org.example.service.chain.JourneyContext;
import org.example.service.chain.JourneyHandler;
import org.springframework.stereotype.Component;

@Component
public class ConsumerOcrHandler extends JourneyHandler {

    private final OcrClient ocrClient;

    public ConsumerOcrHandler(OcrClient ocrClient) {
        this.ocrClient = ocrClient;
    }


    @Override
    public void processar(JourneyContext context) {
        System.out.println("Processing Consumer ocr Journey");

        if (context.getProcessed() || context.getProcesssing()) {
            context.setJourney("ocr");
            super.processar(context);
        }
        ocrClient.evaluate(context.getJourney());
        context.setProcesssing(true);
        context.setProcessed(false);
        context.setJourney("ocr");
        super.processar(context);
    }

}
