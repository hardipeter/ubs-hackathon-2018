package com.ubs.greenheroes.data;

public class HoldingRanking implements Comparable<HoldingRanking> {

    private final String name;
    private final Float ranking;
    private final Float portfolioWeight;

    public HoldingRanking(String name, Float ranking, Float portfolioWeight) {
        this.name = name;
        this.ranking = ranking;
        this.portfolioWeight = portfolioWeight;
    }

    public String getName() {
        return name;
    }

    public Float getRanking() {
        return ranking;
    }

    public Float getPortfolioWeight() {
        return portfolioWeight;
    }

    @Override
    public int compareTo(HoldingRanking that) {
        return this.ranking.compareTo(that.ranking) * -1;
    }
}
