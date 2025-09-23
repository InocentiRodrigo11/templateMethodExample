package org.example.service.chain;

public class JourneyContext {


    private String payload;

    public JourneyContext(Boolean isProcessed, String journey) {
        this.isProcessed = isProcessed;
        this.journey = journey;
    }

    public String getJourney() {
        return journey;
    }

    public void setJourney(String journey) {
        this.journey = journey;
    }

    public Boolean getProcessed() {
        return isProcessed;
    }

    public void setProcessed(Boolean processed) {
        isProcessed = processed;
    }

    private String journey;

    private Boolean isProcessed = Boolean.FALSE;

    public Boolean getProcesssing() {
        return isProcesssing;
    }

    public void setProcesssing(Boolean processsing) {
        isProcesssing = processsing;
    }

    private Boolean isProcesssing = Boolean.FALSE;


}

