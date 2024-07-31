package com.kakaopay.model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class for Stock View Log.
 */
@Entity
@Table(name = "STOCK_VIEW_LOG")
public class StockViewLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    @Column(name = "STOCK_CODE", nullable = false)
    private String stockCode;

    @Column(name = "VIEW_TIME", nullable = false)
    private LocalDateTime viewTime;

    @Column(name = "VIEW_COUNT", nullable = false)
    private int viewCount;

    @Column(name = "USER_ID", nullable = false)
    private String userId;

    // Getters and setters

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public LocalDateTime getViewTime() {
        return viewTime;
    }

    public void setViewTime(LocalDateTime viewTime) {
        this.viewTime = viewTime;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
