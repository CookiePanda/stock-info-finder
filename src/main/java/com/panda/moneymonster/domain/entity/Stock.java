package com.panda.moneymonster.domain.entity;

public class Stock {
    private int id;
    private String stockCode;
    private String stockName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                '}';
    }
}
