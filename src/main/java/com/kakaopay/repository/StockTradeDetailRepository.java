package com.kakaopay.repository;

import com.kakaopay.model.StockTradeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTradeDetailRepository extends JpaRepository<StockTradeDetail, Long> {
}
