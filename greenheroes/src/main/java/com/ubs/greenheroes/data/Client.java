package com.ubs.greenheroes.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    private final String name;

    private final List<ClientPreferenceCategory> preferenceCategories = new ArrayList<>();

    private final List<InstrumentHolding> instrumentHoldings = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    public void addPreferenceCategory(ClientPreferenceCategory category) {
        this.preferenceCategories.add(category);
    }

    public void addInstrumentHoldings(List<InstrumentHolding> instrumentHoldings) {
        this.instrumentHoldings.addAll(instrumentHoldings);
    }

    public ClientPreference getClientPreference(int id) {
        for (ClientPreferenceCategory category : preferenceCategories) {
            for (ClientPreference preference : category.getPreferences()) {
                if (preference.getID() == id) {
                    return preference;
                }
            }
        }
        return null;
    }

    public float getClientPreferenceInterestLevelMultiplier(String name) {
        float multiplier = 0;

        for (ClientPreferenceCategory category : preferenceCategories) {
            for (ClientPreference preference : category.getPreferences()) {
                if (preference.getName().equals(name)) {
                    multiplier = preference.getLevelOfInterest().getInterestMultiplier();
                }
            }
        }

        return multiplier;
    }

    public List<ClientPreferenceCategory> getCategories() {
        return Collections.unmodifiableList(preferenceCategories);
    }

    public String getClientName() {
        return name;
    }

    public List<InstrumentHolding> getInstrumentHoldings() {
        return Collections.unmodifiableList(instrumentHoldings);
    }
}
