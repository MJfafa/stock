package com.kakaopay.service;

import com.kakaopay.model.StockInfo;
import com.kakaopay.repository.StockInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing Stock Information.
 */
@Service
public class StockInfoService {

    @Autowired
    private StockInfoRepository stockInfoRepository;

    /**
     * 모든 주식 정보를 가져옵니다.
     *
     * @return 모든 주식 정보 리스트
     */
    public List<StockInfo> getAllStocks() {
        return stockInfoRepository.findAll();
    }

    /**
     * ID로 주식 정보를 가져옵니다.
     *
     * @param id 주식 ID
     * @return 주식 정보
     */
    public StockInfo getStockById(Long id) {
        return stockInfoRepository.findById(id).orElse(null);
    }

    /**
     * 주식 정보를 저장합니다.
     *
     * @param stockInfo 저장할 주식 정보
     * @return 저장된 주식 정보
     */
    public StockInfo saveStock(StockInfo stockInfo) {
        return stockInfoRepository.save(stockInfo);
    }
}
