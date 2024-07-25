package com.kakaopay.controller;

import com.kakaopay.model.Stock;
import com.kakaopay.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/api/rankings")
    public List<Stock> getRankings(@RequestParam String tag) {
        return stockService.getStocksByTag(tag);
    }

    @GetMapping("/api/test/update")
    public void updateRandomStockData() {
        stockService.updateRandomStockData();
    }
}
