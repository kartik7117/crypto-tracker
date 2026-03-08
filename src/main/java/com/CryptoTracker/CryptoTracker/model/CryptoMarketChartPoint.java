package com.CryptoTracker.CryptoTracker.model;

public class CryptoMarketChartPoint {
    private long time;
    private double prices;
    private double marketcap;
    private double volume;

    public CryptoMarketChartPoint(long time, double prices, double marketcap, double volume) {
        this.time = time;
        this.prices = prices;
        this.marketcap = marketcap;
        this.volume = volume;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public double getMarketcap() {
        return marketcap;
    }

    public void setMarketcap(double marketcap) {
        this.marketcap = marketcap;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
