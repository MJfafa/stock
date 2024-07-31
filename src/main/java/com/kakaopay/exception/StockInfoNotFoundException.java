package com.kakaopay.exception;

/**
 * Custom exception thrown when a StockInfo is not found.
 */
public class StockInfoNotFoundException extends RuntimeException {
    public StockInfoNotFoundException(String message) {
        super(message);
    }
}
