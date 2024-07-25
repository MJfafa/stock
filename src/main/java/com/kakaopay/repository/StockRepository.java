package com.kakaopay.repository;

import com.kakaopay.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT s FROM Stock s ORDER BY s.volume DESC")
    List<Stock> findHighVolumeStocks();

    @Query("SELECT s FROM Stock s WHERE s.price > 100 ORDER BY s.price DESC")
    List<Stock> findRisingStocks();

    @Query("SELECT s FROM Stock s WHERE s.price < 50 ORDER BY s.price ASC")
    List<Stock> findFallingStocks();

    @Query("SELECT s FROM Stock s ORDER BY s.name")
    List<Stock> findPopularStocks();
}
