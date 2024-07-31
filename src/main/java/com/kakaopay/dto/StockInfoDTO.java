package com.kakaopay.dto;

import java.math.BigDecimal;

/**
 * 주식 정보 DTO 클래스
 */
public class StockInfoDTO {

    private Long id;
    private String code;
    private String name;
    private BigDecimal price;
    private Long volume;
    private String sector;
    private double changeRate;

    public StockInfoDTO(Long id, String code, String name, BigDecimal price, Long volume, String sector, double changeRate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.volume = volume;
        this.sector = sector;
        this.changeRate = changeRate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public double getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }
}
