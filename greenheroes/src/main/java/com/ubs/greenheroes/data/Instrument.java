package com.ubs.greenheroes.data;

import java.util.HashMap;
import java.util.Map;

public class Instrument {

    private final String name;
    private final Map<String, Float> preferenceMap = new HashMap<>();

    public Instrument(String name) {
        this.name = name;
    }

    public String getPortfolioName() {
        return name;
    }

    public void addPreferenceWeigth(String preference, float value) {
        preferenceMap.put(preference, value);
    }
}
