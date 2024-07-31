package com.kakaopay.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 주식 일일 거래 엔티티 클래스
 */
@Entity
@Table(name = "STOCK_DAILY_TRADE")
public class StockDailyTrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRADE_ID")
    private Long id;

    @Column(name = "STOCK_CODE", nullable = false)
    private String stockCode;

    @Column(name = "TRADE_DATE", nullable = false)
    private LocalDateTime tradeDate;

    @Column(name = "VOLUME", nullable = false)
    private Long volume;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

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

    public LocalDateTime getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
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
