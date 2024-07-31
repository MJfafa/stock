package com.kakaopay.repository;

import com.kakaopay.model.StockDailyTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 주식 일일 거래 엔티티에 대한 CRUD 작업을 수행하는 리포지토리 인터페이스
 */
@Repository
public interface StockDailyTradeRepository extends JpaRepository<StockDailyTrade, Long> {

    /**
     * 특정 주식 코드에 대한 일일 거래 내역을 거래 날짜 내림차순으로 찾습니다.
     * 이 메서드는 JPQL 쿼리를 사용하여 주식 코드를 기준으로 일일 거래 내역을 검색합니다.
     *
     * @param code 주식 코드
     * @return 주식 코드에 대한 일일 거래 내역 목록
     */
    @Query(value = "SELECT * FROM STOCK_DAILY_TRADE WHERE STOCK_CODE = ?1 ORDER BY TRADE_DATE DESC", nativeQuery = true)
    List<StockDailyTrade> findByCodeOrderByTradeDateDesc(String code);

    /**
     * 오늘 거래량이 가장 많은 주식을 찾습니다.
     * 이 메서드는 오늘의 거래량 내림차순으로 정렬된 주식 목록을 검색합니다.
     *
     * @return 거래량 내림차순으로 정렬된 주식 목록
     */
    @Query(value = "SELECT * FROM STOCK_DAILY_TRADE WHERE TRADE_DATE = CURDATE() ORDER BY VOLUME DESC", nativeQuery = true)
    List<StockDailyTrade> findTopByOrderByTradeVolumeDesc();

    /**
     * 오늘 상승률이 가장 높은 주식을 찾습니다.
     * 이 메서드는 오늘의 상승률 내림차순으로 정렬된 주식 목록을 검색합니다.
     *
     * @return 상승률 내림차순으로 정렬된 주식 목록
     */
    @Query(value = "SELECT * FROM STOCK_DAILY_TRADE WHERE TRADE_DATE = CURDATE() ORDER BY CHANGE_RATE DESC", nativeQuery = true)
    List<StockDailyTrade> findTopByOrderByChangeRateDesc();

    /**
     * 오늘 하락률이 가장 높은 주식을 찾습니다.
     * 이 메서드는 오늘의 하락률 오름차순으로 정렬된 주식 목록을 검색합니다.
     *
     * @return 하락률 오름차순으로 정렬된 주식 목록
     */
    @Query(value = "SELECT * FROM STOCK_DAILY_TRADE WHERE TRADE_DATE = CURDATE() ORDER BY CHANGE_RATE ASC", nativeQuery = true)
    List<StockDailyTrade> findTopByOrderByChangeRateAsc();
}
