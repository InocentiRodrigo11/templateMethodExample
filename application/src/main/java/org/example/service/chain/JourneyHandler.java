package org.example.service.chain;

public abstract class JourneyHandler {

    protected JourneyHandler netxtHandler;

    public JourneyHandler setNextHandler(JourneyHandler nextHandler) {
        this.netxtHandler = nextHandler;
        return nextHandler;
    }

    public void processar(JourneyContext context) {
        if (netxtHandler != null) {
            netxtHandler.processar(context);
        } else {
            throw new IllegalArgumentException("No handler found for the given context");
        }
    }
}
