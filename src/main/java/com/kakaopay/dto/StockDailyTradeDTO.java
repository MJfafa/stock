package com.kakaopay.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 주식 일일 거래 DTO 클래스
 */
public class StockDailyTradeDTO {

    private Long id;
    private String stockCode;
    private LocalDate tradeDate;
    private Long volume;
    private BigDecimal price;

    public StockDailyTradeDTO(Long id, String stockCode, LocalDate tradeDate, Long volume, BigDecimal price) {
        this.id = id;
        this.stockCode = stockCode;
        this.tradeDate = tradeDate;
        this.volume = volume;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
