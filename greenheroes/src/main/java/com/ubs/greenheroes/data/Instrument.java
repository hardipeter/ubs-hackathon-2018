package com.ubs.greenheroes.data;

import java.util.HashMap;
import java.util.Map;

public class Instrument {

    private final String name;
    private final Map<String, Float> rankingPerCategory = new HashMap<>();

    public Instrument(String name) {
        this.name = name;
    }

    public void addRankingForCategory(String categoryName, float ranking) {
        rankingPerCategory.put(categoryName, ranking);
    }

    public String getName() {
        return name;
    }

    public Map<String, Float> getRankingPerCategory() {
        return rankingPerCategory;
    }
}
