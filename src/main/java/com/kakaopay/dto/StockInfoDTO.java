package com.kakaopay.dto;

import java.math.BigDecimal;

public class StockInfoDTO {
    private String stockCode;
    private Double price;         // 현재가
    private Double closePrice;    // 전일 종가
    private Long volume;
    private Double priceIncreaseRate; // 가격 상승률

    public StockInfoDTO(String stockCode, Double price, Double closePrice, Long volume, Double priceIncreaseRate) {
        this.stockCode = stockCode;
        this.price = price;
        this.closePrice = closePrice;
        this.volume = volume;
        this.priceIncreaseRate = priceIncreaseRate;
    }

    // getters and setters
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(Double closePrice) {
        this.closePrice = closePrice;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Double getPriceIncreaseRate() {
        return priceIncreaseRate;
    }

    public void setPriceIncreaseRate(Double priceIncreaseRate) {
        this.priceIncreaseRate = priceIncreaseRate;
    }
}
