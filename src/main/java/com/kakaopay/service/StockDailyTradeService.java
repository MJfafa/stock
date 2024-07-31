package com.kakaopay.service;

import com.kakaopay.exception.StockDailyTradeNotFoundException;
import com.kakaopay.model.StockDailyTrade;
import com.kakaopay.repository.StockDailyTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockDailyTradeService {

    @Autowired
    private StockDailyTradeRepository stockDailyTradeRepository;

    public List<StockDailyTrade> getAllStockDailyTrades() {
        return stockDailyTradeRepository.findAll();
    }

    public StockDailyTrade getStockDailyTradeById(Long id) {
        return stockDailyTradeRepository.findById(id)
                .orElseThrow(() -> new StockDailyTradeNotFoundException("StockDailyTrade not found with id: " + id));
    }

    public StockDailyTrade saveStockDailyTrade(StockDailyTrade stockDailyTrade) {
        return stockDailyTradeRepository.save(stockDailyTrade);
    }

    public void deleteStockDailyTrade(Long id) {
        stockDailyTradeRepository.deleteById(id);
    }
}
