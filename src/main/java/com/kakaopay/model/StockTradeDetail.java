package com.kakaopay.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Entity representing the stock trade detail.
 */
@Entity
@Table(name = "STOCK_TRADE_DETAIL")
public class StockTradeDetail {

    @Id
    private Long id;

    @Column(name = "trade_date")
    private LocalDateTime tradeDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "code")
    private String code;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "trade_volume")
    private int tradeVolume;

    @Column(name = "trade_price")
    private int tradePrice;

    @Column(name = "trade_time")
    private LocalDateTime tradeTime;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDateTime tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public int getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(int tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public int getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(int tradePrice) {
        this.tradePrice = tradePrice;
    }

    public LocalDateTime getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(LocalDateTime tradeTime) {
        this.tradeTime = tradeTime;
    }
}
