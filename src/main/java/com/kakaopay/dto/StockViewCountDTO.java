package com.kakaopay.dto;

/**
 * 주식 조회 수 DTO(Data Transfer Object) 클래스.
 * 주식의 조회 수 정보를 담고 있습니다.
 */
public class StockViewCountDTO {

    private String stockCode; // 주식 코드
    private int viewCount; // 조회 수

    /**
     * 기본 생성자.
     */
    public StockViewCountDTO() {
    }

    /**
     * 매개변수가 있는 생성자.
     *
     * @param stockCode 주식 코드
     * @param viewCount 조회 수
     */
    public StockViewCountDTO(String stockCode, int viewCount) {
        this.stockCode = stockCode;
        this.viewCount = viewCount;
    }

    // Getter와 Setter 메서드들

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
