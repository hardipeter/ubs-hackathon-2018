package com.ubs.greenheroes.data;

public class ClientPreference {

    private final String name;
    private InterestLevel levelOfInterest = InterestLevel.LOW;

    public ClientPreference(String name, InterestLevel level) {
        this.name = name;
        setLevelOfInterest(level);
    }

    public String getName() {
        return name;
    }

    public InterestLevel getLevelOfInterest() {
        return levelOfInterest;
    }

    public final void setLevelOfInterest(InterestLevel levelOfInterest) {
        this.levelOfInterest = levelOfInterest;
    }
}
