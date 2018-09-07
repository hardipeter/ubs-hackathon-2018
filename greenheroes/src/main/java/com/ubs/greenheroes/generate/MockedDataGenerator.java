package com.ubs.greenheroes.generate;

import com.ubs.greenheroes.data.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.springframework.util.ResourceUtils;

public class MockedDataGenerator {

    private static final List<String> CATEGORY_NAME_LIST = Arrays.asList("Pollution and waste", "Climate change", "Water", "People", "Products and services", "Governance", "Ethics");
    private static final Random RANDOM = new Random(0); //0, to always get the same randoms for proper testing

    private MockedDataGenerator() {
    }

    public static void createMockedClient() throws FileNotFoundException {
        Client client = new Client("Luke Skywalker");
        ClientPreferenceCategory category = new ClientPreferenceCategory("Environmental");
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(0), 0, InterestLevel.LOW));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(1), 1, InterestLevel.HIGH));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(2), 2, InterestLevel.MEDIUM));
        client.addPreferenceCategory(category);

        category = new ClientPreferenceCategory("Social");
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(3), 3, InterestLevel.LOW));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(4), 4, InterestLevel.HIGH));
        client.addPreferenceCategory(category);

        category = new ClientPreferenceCategory("Governance");
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(5), 5, InterestLevel.HIGH));
        category.addPreference(new ClientPreference(CATEGORY_NAME_LIST.get(6), 6, InterestLevel.LOW));
        client.addPreferenceCategory(category);

        client.addInstrumentHoldings(generateInstrumentHoldings());

        MockedDatabase.CLIENT = client;
    }

    private static List<InstrumentHolding> generateInstrumentHoldings() throws FileNotFoundException {

        createMockedInstruments();

        List<InstrumentHolding> instrumentHoldings = new ArrayList<>();

        float total = 1f;
        for (int i = 0; i < 14; i++) { //amount of instruments for the client mocked
            float weight = RANDOM.nextFloat() * total / 2;
            total -= weight;
            InstrumentHolding holding = new InstrumentHolding(MockedDatabase.INSTRUMENTS.get(i), weight);
            instrumentHoldings.add(holding);
        }
        instrumentHoldings.add(new InstrumentHolding(MockedDatabase.INSTRUMENTS.get(14), total));

        return instrumentHoldings;
    }

    private static void createMockedInstruments() throws FileNotFoundException {
        for (String companyName : MockedDataGenerator.readInCompanyNames()) {
            Instrument instrument = new Instrument(companyName);
            CATEGORY_NAME_LIST.forEach((categoryName) -> {
                float ranking = RANDOM.nextFloat() * 100;
                ranking = formatFloat(ranking, 5);
                instrument.addRankingForCategory(categoryName, ranking);
            });
            MockedDatabase.INSTRUMENTS.add(instrument);
        }
    }

    private static List<String> readInCompanyNames() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:companies.txt");
        Scanner s = new Scanner(file).useDelimiter("[|\n]");
        ArrayList<String> nameList = new ArrayList<>();
        while (s.hasNext()) {
            nameList.add(s.next());
        }
        s.close();

        return nameList;
    }

    public static float formatFloat(float number, int decimals) {
        return Math.round(number * Math.pow(10, decimals)) / (float) Math.pow(10, decimals);
    }
}
