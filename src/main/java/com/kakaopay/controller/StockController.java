package com.kakaopay.controller;

import com.kakaopay.dto.StockDailyTradeDTO;
import com.kakaopay.dto.StockInfoDTO;
import com.kakaopay.dto.StockViewCountDTO;
import com.kakaopay.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 주식 관련 요청을 처리하는 컨트롤러 클래스입니다.
 * 주식의 정보, 거래, 조회수 등의 정보를 제공합니다.
 */
@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * 특정 주식 코드에 대한 주식 정보를 반환합니다.
     *
     * @param code 주식 코드
     * @return 주식 정보
     */
    @GetMapping("/info/{code}")
    public StockInfoDTO getStockInfo(@PathVariable String code) {
        return stockService.getStockInfoByCode(code);
    }

    /**
     * 특정 주식 코드에 대한 일일 거래 정보를 반환합니다.
     *
     * @param code 주식 코드
     * @return 일일 거래 정보 리스트
     */
    @GetMapping("/daily-trades/{code}")
    public List<StockDailyTradeDTO> getDailyTrades(@PathVariable String code) {
        return stockService.getDailyTradesByCode(code);
    }

    /**
     * 거래량이 많은 주식 정보를 반환합니다.
     *
     * @return 거래량 상위 주식 정보 리스트
     */
    @GetMapping("/volume")
    public List<StockInfoDTO> getTopVolumeStocks() {
        return stockService.getStocksByVolume();
    }

    /**
     * 최근 한 시간 동안 가장 많이 조회된 주식 정보를 페이지네이션하여 반환합니다.
     *
     * @param page 요청 페이지 번호
     * @param size 페이지 크기
     * @return 최근 한 시간 동안 많이 조회된 주식 정보 리스트
     */
    @GetMapping("/popular")
    public List<StockViewCountDTO> getPopularStocks(@RequestParam int page, @RequestParam int size) {
        return stockService.getMostPopularStocksWithViewCount(page, size);
    }
    /**
     * 상승률이 높은 상위 주식 정보를 반환합니다.
     *
     * @return 상승률 상위 주식 정보 리스트
     */
    @GetMapping("/top-rising")
    public List<StockInfoDTO> getTopRisingStocks() {
        return stockService.getTopRisingStocks();
    }

    /**
     * 하락률이 높은 상위 주식 정보를 반환합니다.
     *
     * @return 하락률 상위 주식 정보 리스트
     */
    @GetMapping("/top-falling")
    public List<StockInfoDTO> getTopFallingStocks() {
        return stockService.getTopFallingStocks();
    }
}
