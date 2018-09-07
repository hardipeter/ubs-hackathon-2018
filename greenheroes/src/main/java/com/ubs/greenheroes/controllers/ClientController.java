package com.ubs.greenheroes.controllers;


import com.ubs.greenheroes.data.Client;
import com.ubs.greenheroes.data.InstrumentHolding;
import com.ubs.greenheroes.data.MockedDatabase;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    static final String ACCEPTED_ORIGINS = "http://localhost:3000";

    @CrossOrigin(origins = ACCEPTED_ORIGINS)
    @RequestMapping("/clients/holdings")
    public Map<String, Float> getClientHoldingsWithRanking() {
        return calculateClientHoldingsWithRanking();
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
            result +=  (rankingPerHolding.get(instrumentName) * holding.getPortfolioWeighting());
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
                float ranking = (client.getClientPreferenceInterestLevelMultiplier(category.getKey()) * category.getValue()) / 7;
                result.put(holding.getInstrument().getName(), ranking);
            });
        }
        return result;
    }
}
