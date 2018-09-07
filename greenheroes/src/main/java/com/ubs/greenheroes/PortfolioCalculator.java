package com.ubs.greenheroes;

import com.ubs.greenheroes.data.Client;
import com.ubs.greenheroes.data.Instrument;
import com.ubs.greenheroes.data.MockedDatabase;

/**
 *
 * @author hardipeter
 */
class PortfolioCalculator {

    public static void calculate(Client client) {
        for (Instrument instrument : MockedDatabase.INSTRUMENTS) {
            float value = 0;
        }
    }

    private PortfolioCalculator() {
    }
}
