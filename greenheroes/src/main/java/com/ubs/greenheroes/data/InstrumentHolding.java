package com.ubs.greenheroes.data;

public class InstrumentHolding {

    private final Instrument instrument;
    private final float portfolioWeighting;

    public InstrumentHolding(Instrument instrument, float portfolioWeighting) {
        this.instrument = instrument;
        this.portfolioWeighting = portfolioWeighting;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public float getPortfolioWeighting() {
        return portfolioWeighting;
    }
}
