package com.kakaopay.exception;

public class StockDailyTradeNotFoundException extends RuntimeException {
    public StockDailyTradeNotFoundException(String message) {
        super(message);
    }
}
