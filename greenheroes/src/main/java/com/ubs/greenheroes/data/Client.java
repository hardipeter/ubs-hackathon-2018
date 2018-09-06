package com.ubs.greenheroes.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    private final List<ClientPreferenceCategory> preferenceCategories = new ArrayList<>();

    public List<ClientPreferenceCategory> getCategories() {
        return Collections.unmodifiableList(preferenceCategories);
    }
}
