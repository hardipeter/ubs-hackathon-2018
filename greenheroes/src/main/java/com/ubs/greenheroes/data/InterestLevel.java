package com.ubs.greenheroes.data;

public enum InterestLevel {

    LOW(1.5f),
    MEDIUM(1f),
    HIGH(0.5f);

    private final float interestMultiplier;

    InterestLevel(float interestMultiplier) {
        this.interestMultiplier = interestMultiplier;
    }

    public float getInterestMultiplier() {
        return interestMultiplier;
    }
}
