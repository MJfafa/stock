package com.kakaopay.service;

import com.kakaopay.dto.StockDailyTradeDTO;
import com.kakaopay.dto.StockInfoDTO;
import com.kakaopay.dto.StockViewCountDTO;
import com.kakaopay.repository.StockDailyTradeRepository;
import com.kakaopay.repository.StockInfoRepository;
import com.kakaopay.repository.StockViewLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;

/**
 * 주식 서비스 클래스.
 * 주식 관련 비즈니스 로직을 처리합니다.
 */
@Service
public class StockService {

    private static final Logger logger = LoggerFactory.getLogger(StockService.class); // Logger 변수 정의

    @Autowired
    private StockDailyTradeRepository stockDailyTradeRepository;

    @Autowired
    private StockInfoRepository stockInfoRepository;

    @Autowired
    private StockViewLogRepository stockViewLogRepository;

    /**
     * 주식 코드를 이용하여 주식 정보를 조회합니다.
     * 
     * @param code 주식 코드
     * @return 주식 정보 DTO
     */
    public StockInfoDTO getStockInfoByCode(String code) {
        logger.info("Fetching stock information for code: {}", code);
        return stockInfoRepository.findByCode(code)
                .map(stock -> new StockInfoDTO(stock.getId(), stock.getCode(), stock.getName(), stock.getPrice(),
                        stock.getVolume(), stock.getSector(), stock.getChangeRate()))
                .orElseThrow(() -> new RuntimeException("Stock not found with code: " + code));
    }

    /**
     * 주식 코드를 이용하여 일일 거래 내역을 조회합니다.
     * 
     * @param code 주식 코드
     * @return 일일 거래 내역 DTO 목록
     */
    public List<StockDailyTradeDTO> getDailyTradesByCode(String code) {
        logger.info("Fetching daily trades for code: {}", code);
        return stockDailyTradeRepository.findByCodeOrderByTradeDateDesc(code).stream()
                .map(trade -> new StockDailyTradeDTO(trade.getId(), trade.getStockCode(), trade.getTradeDate().toLocalDate(),
                        trade.getVolume(), trade.getPrice()))
                .collect(Collectors.toList());
    }

    /**
     * 거래량이 가장 많은 주식 목록을 조회합니다.
     * 
     * @return 주식 정보 DTO 목록
     */
    public List<StockInfoDTO> getStocksByVolume() {
        logger.info("Fetching stocks with highest volume");
        return stockInfoRepository.findTopByOrderByVolumeDesc().stream()
                .map(result -> new StockInfoDTO(
                        null, // id를 사용하지 않을 경우 null로 전달
                        (String) result[0], // code
                        null, // name을 사용하지 않을 경우 null로 전달
                        null, // price를 사용하지 않을 경우 null로 전달
                        ((BigDecimal) result[1]).longValue(), // volume을 BigDecimal에서 long으로 변환
                        null, // sector를 사용하지 않을 경우 null로 전달
                        0.0)) // changeRate를 사용하지 않을 경우 기본값 전달
                .collect(Collectors.toList());
        
        /*return stockInfoRepository.findTopByOrderByVolumeDesc().stream()
                .map(stock -> new StockInfoDTO(stock.getId(), stock.getCode(), stock.getName(), stock.getPrice(),
                        stock.getVolume(), stock.getSector(), stock.getChangeRate()))
                .collect(Collectors.toList());
                */
    }

    /**
     * 조회수가 가장 많은 주식 목록을 페이지네이션하여 조회합니다.
     * 
     * @param page 페이지 번호
     * @param size 한 페이지에 포함될 항목 수
     * @return 조회수 DTO 목록
     */
    public List<StockViewCountDTO> getMostPopularStocksWithViewCount(int page, int size) {
        logger.info("Fetching most popular stocks with page: {}, size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size);
        List<Object[]> results = stockViewLogRepository.findTopByViewTimeAfterOrderByViewCountDesc(pageable);
        
        logger.info("Query returned {} results.", results.size());
        return results.stream()
                .map(viewLog -> new StockViewCountDTO((String) viewLog[0], ((Number) viewLog[1]).intValue()))
                .collect(Collectors.toList());
    }

    /**
     * 상승률이 가장 높은 주식 목록을 조회합니다.
     * 
     * @return 주식 정보 DTO 목록
     */
    public List<StockInfoDTO> getTopRisingStocks() {
        logger.info("Fetching top rising stocks");
        return stockInfoRepository.findTopByOrderByChangeRateDesc().stream()
                .map(stock -> new StockInfoDTO(stock.getId(), stock.getCode(), stock.getName(), stock.getPrice(),
                        stock.getVolume(), stock.getSector(), stock.getChangeRate()))
                .collect(Collectors.toList());
    }

    /**
     * 하락률이 가장 높은 주식 목록을 조회합니다.
     * 
     * @return 주식 정보 DTO 목록
     */
    public List<StockInfoDTO> getTopFallingStocks() {
        logger.info("Fetching top falling stocks");
        return stockInfoRepository.findTopByOrderByChangeRateAsc().stream()
                .map(stock -> new StockInfoDTO(stock.getId(), stock.getCode(), stock.getName(), stock.getPrice(),
                        stock.getVolume(), stock.getSector(), stock.getChangeRate()))
                .collect(Collectors.toList());
    }
}
