package com.ubs.greenheroes.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientPreferenceCategory {

    private final String name;
    private final List<ClientPreference> preferences = new ArrayList<>();

    public ClientPreferenceCategory(String name) {
        this.name = name;
    }

    public void addPreference(ClientPreference preference) {
        preferences.add(preference);
    }

    public List<ClientPreference> getPreferences() {
        return Collections.unmodifiableList(preferences);
    }

    public String getName() {
        return name;
    }
}
