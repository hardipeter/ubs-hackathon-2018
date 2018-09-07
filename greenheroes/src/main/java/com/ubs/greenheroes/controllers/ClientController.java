package com.ubs.greenheroes.controllers;

import com.ubs.greenheroes.data.Client;
import com.ubs.greenheroes.data.HoldingRanking;
import com.ubs.greenheroes.data.InstrumentHolding;
import com.ubs.greenheroes.data.MockedDatabase;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    static final String ACCEPTED_ORIGINS = "http://localhost:3000";

    @CrossOrigin(origins = ACCEPTED_ORIGINS)
    @RequestMapping("/clients/holdings")
    public List<HoldingRanking> getClientHoldingsWithRanking() {
        List<HoldingRanking> result = new ArrayList<>();
        Map<String, Float> rankingPerHolding = calculateClientHoldingsWithRanking();

        Client client = MockedDatabase.CLIENT;
        List<InstrumentHolding> holdings = client.getInstrumentHoldings();

        for (InstrumentHolding holding : holdings) {
            String instrumentName = holding.getInstrument().getName();
            result.add(new HoldingRanking(instrumentName, rankingPerHolding.get(instrumentName), holding.getPortfolioWeighting()));
        }

        Collections.sort(result);

        return result;
    }

    @CrossOrigin(origins = ACCEPTED_ORIGINS)
    @RequestMapping("/clients/holdings/remove/{id}")
    public void removeID(@PathVariable(name = "id") int id) {
        Client client = MockedDatabase.CLIENT;
        if (client.getInstrumentHoldings().size() > id) {
            client.getInstrumentHoldings().remove(id);
        }
    }

    @CrossOrigin(origins = ACCEPTED_ORIGINS)
    @RequestMapping("/clients/ranking")
    public float getClientRanking() {
        float result = 0f;
        Map<String, Float> rankingPerHolding = calculateClientHoldingsWithRanking();

        Client client = MockedDatabase.CLIENT;
        List<InstrumentHolding> holdings = client.getInstrumentHoldings();

        for (InstrumentHolding holding : holdings) {
            String instrumentName = holding.getInstrument().getName();
            result += (rankingPerHolding.get(instrumentName) * holding.getPortfolioWeighting());
        }

        return result / holdings.size();

    }

    private Map<String, Float> calculateClientHoldingsWithRanking() {
        Map<String, Float> result = new HashMap<>();

        Client client = MockedDatabase.CLIENT;
        List<InstrumentHolding> holdings = client.getInstrumentHoldings();

        for (InstrumentHolding holding : holdings) {
            Map<String, Float> rankings = holding.getInstrument().getRankingPerCategory();

            rankings.entrySet().forEach((category) -> {
                float ranking = (client.getClientPreferenceInterestLevelMultiplier(category.getKey()) * category.getValue()) / 7f;
                Float currentValue = result.get(holding.getInstrument().getName());
                if (currentValue == null) {
                    result.put(holding.getInstrument().getName(), ranking);
                }
                else {
                    result.put(holding.getInstrument().getName(), ranking + currentValue);
                }
            });
        }
        return result;
    }
}
