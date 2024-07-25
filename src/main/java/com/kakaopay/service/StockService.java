package com.kakaopay.service;

import com.kakaopay.model.Stock;
import com.kakaopay.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getStocksByTag(String tag) {
        switch (tag) {
            case "popular":
                return stockRepository.findPopularStocks();
            case "rising":
                return stockRepository.findRisingStocks();
            case "falling":
                return stockRepository.findFallingStocks();
            case "volume":
                return stockRepository.findHighVolumeStocks();
            default:
                throw new IllegalArgumentException("Invalid tag");
        }
    }

    public void updateRandomStockData() {
        Random random = new Random();
        List<Stock> stocks = stockRepository.findAll();
        for (Stock stock : stocks) {
            stock.setPrice(stock.getPrice() * (0.9 + (1.1 - 0.9) * random.nextDouble()));
            stockRepository.save(stock);
        }
    }
}
