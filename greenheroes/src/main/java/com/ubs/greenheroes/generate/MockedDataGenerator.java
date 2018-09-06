package com.ubs.greenheroes.generate;

import com.ubs.greenheroes.data.Client;
import com.ubs.greenheroes.data.ClientPreference;
import com.ubs.greenheroes.data.ClientPreferenceCategory;
import com.ubs.greenheroes.data.Instrument;
import com.ubs.greenheroes.data.InterestLevel;
import com.ubs.greenheroes.data.MockedDatabase;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MockedDataGenerator {

    private static final List<String> CATEGORY_NAME_LIST = Arrays.asList("Pollution and waste", "Climate change", "Water", "People", "Products and services", "Governance", "Ethics");
    private static final Random RANDOM = new Random(0); //0, to always get the same randoms for proper testing

    public static void createMockedInstruments() {
        for (int i = 0; i < 10000; ++i) {
            Instrument portfolio = new Instrument("Instrument " + i);
            CATEGORY_NAME_LIST.stream().forEach((name) -> {
                float weight = RANDOM.nextFloat() * 100;
                weight = formatWeight(weight);
                portfolio.addPreferenceWeigth(name, weight);
            });
            MockedDatabase.INSTRUMENTS.add(portfolio);
        }
    }

    public static void createMockedClient() {
        Client client = new Client("Luke Skywalker");
        ClientPreferenceCategory category = new ClientPreferenceCategory("Environmental");
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(0), 0, InterestLevel.LOW));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(1), 1, InterestLevel.HIGH));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(2), 2, InterestLevel.LOW));
        client.addPreferenceCategory(category);

        category = new ClientPreferenceCategory("Social");
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(3), 3, InterestLevel.LOW));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(4), 4, InterestLevel.HIGH));
        client.addPreferenceCategory(category);

        category = new ClientPreferenceCategory("Governance");
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(5), 5, InterestLevel.HIGH));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(6), 6, InterestLevel.LOW));
        client.addPreferenceCategory(category);
        MockedDatabase.CLIENT = client;
    }

    private static float formatWeight(float weight) {
        return Math.round(weight * 100000f) / 100000f;
    }

    private MockedDataGenerator() {
    }
}
