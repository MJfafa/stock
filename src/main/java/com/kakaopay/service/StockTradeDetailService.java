package com.kakaopay.service;

import com.kakaopay.exception.StockTradeDetailNotFoundException;
import com.kakaopay.model.StockTradeDetail;
import com.kakaopay.repository.StockTradeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service provides operations related to stock trade details.
 */
@Service
public class StockTradeDetailService {

    @Autowired
    private StockTradeDetailRepository stockTradeDetailRepository;

    /**
     * Retrieves all stock trade details.
     * @return a list of stock trade details
     */
    public List<StockTradeDetail> getAllStockTradeDetails() {
        return stockTradeDetailRepository.findAll();
    }

    /**
     * Retrieves stock trade detail by ID.
     * @param id the stock trade detail ID
     * @return the stock trade detail
     * @throws StockTradeDetailNotFoundException if the stock trade detail is not found
     */
    public StockTradeDetail getStockTradeDetailById(Long id) {
        return stockTradeDetailRepository.findById(id)
                .orElseThrow(() -> new StockTradeDetailNotFoundException("StockTradeDetail not found with id: " + id));
    }

    /**
     * Creates a new stock trade detail.
     * @param stockTradeDetail the stock trade detail to create
     * @return the created stock trade detail
     */
    public StockTradeDetail createStockTradeDetail(StockTradeDetail stockTradeDetail) {
        return stockTradeDetailRepository.save(stockTradeDetail);
    }

    /**
     * Updates an existing stock trade detail.
     * @param id the ID of the stock trade detail to update
     * @param stockTradeDetail the updated stock trade detail
     * @return the updated stock trade detail
     * @throws StockTradeDetailNotFoundException if the stock trade detail is not found
     */
    public StockTradeDetail updateStockTradeDetail(Long id, StockTradeDetail stockTradeDetail) {
        StockTradeDetail existingStockTradeDetail = stockTradeDetailRepository.findById(id)
                .orElseThrow(() -> new StockTradeDetailNotFoundException("StockTradeDetail not found with id: " + id));

        existingStockTradeDetail.setTradeDate(stockTradeDetail.getTradeDate());
        existingStockTradeDetail.setUserId(stockTradeDetail.getUserId());
        existingStockTradeDetail.setCode(stockTradeDetail.getCode());
        existingStockTradeDetail.setTradeType(stockTradeDetail.getTradeType());
        existingStockTradeDetail.setTradeVolume(stockTradeDetail.getTradeVolume());
        existingStockTradeDetail.setTradePrice(stockTradeDetail.getTradePrice());
        existingStockTradeDetail.setTradeTime(stockTradeDetail.getTradeTime());

        return stockTradeDetailRepository.save(existingStockTradeDetail);
    }

    /**
     * Deletes a stock trade detail by ID.
     * @param id the ID of the stock trade detail to delete
     * @throws StockTradeDetailNotFoundException if the stock trade detail is not found
     */
    public void deleteStockTradeDetail(Long id) {
        StockTradeDetail stockTradeDetail = stockTradeDetailRepository.findById(id)
                .orElseThrow(() -> new StockTradeDetailNotFoundException("StockTradeDetail not found with id: " + id));
        stockTradeDetailRepository.delete(stockTradeDetail);
    }
}
