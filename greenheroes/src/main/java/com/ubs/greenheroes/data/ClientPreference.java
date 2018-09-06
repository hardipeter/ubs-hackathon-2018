package com.ubs.greenheroes.data;

public class ClientPreference {

    private final String name;
    private final int id;
    private InterestLevel levelOfInterest = InterestLevel.LOW;

    public ClientPreference(String name, int id, InterestLevel level) {
        this.name = name;
        this.id = id;
        setLevelOfInterest(level);
    }

    public int getID() {
        return id;
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
