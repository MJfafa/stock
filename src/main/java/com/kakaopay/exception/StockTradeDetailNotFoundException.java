package com.kakaopay.exception;

public class StockTradeDetailNotFoundException extends RuntimeException {
    public StockTradeDetailNotFoundException(String message) {
        super(message);
    }
}
