package com.ubs.greenheroes.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientPreferenceCategory {

    private final List<ClientPreference> preferences = new ArrayList<>();

    public List<ClientPreference> getPreferences() {
        return Collections.unmodifiableList(preferences);
    }
}
