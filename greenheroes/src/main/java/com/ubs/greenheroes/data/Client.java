package com.ubs.greenheroes.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    private final String name;

    private final List<ClientPreferenceCategory> preferenceCategories = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    public void addPreferenceCategory(ClientPreferenceCategory category) {
        preferenceCategories.add(category);
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

    public List<ClientPreferenceCategory> getCategories() {
        return Collections.unmodifiableList(preferenceCategories);
    }

    public String getClientName() {
        return name;
    }
}
