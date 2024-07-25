package com.kakaopay;

import com.kakaopay.model.Stock;
import com.kakaopay.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSampleData();
    }

    private void loadSampleData() {
        Stock stock1 = new Stock();
        stock1.setName("Company A");
        stock1.setPrice(120.0);
        stock1.setVolume(1000L);
        stockRepository.save(stock1);

        Stock stock2 = new Stock();
        stock2.setName("Company B");
        stock2.setPrice(80.0);
        stock2.setVolume(500L);
        stockRepository.save(stock2);
    }
}
