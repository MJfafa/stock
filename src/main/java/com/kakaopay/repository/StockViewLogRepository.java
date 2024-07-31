package com.kakaopay.repository;

import com.kakaopay.model.StockViewLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on StockViewLog entities.
 */
public interface StockViewLogRepository extends JpaRepository<StockViewLog, Long> {

    /**
     * Finds the top viewed stocks within the last hour, ordered by view count in descending order.
     * This query retrieves the stocks that have been viewed the most since the given time.
     *
     * @param pageable 페이징 정보를 포함한 페이지 리퀘스트
     * @return a list of arrays containing stock codes and their view counts
     */
    @Query(value = "SELECT STOCK_CODE, COUNT(1) AS VIEW_CNT " +
            "FROM STOCK_VIEW_LOG " +
            "WHERE VIEW_TIME >= DATEADD('HOUR', -1, CURRENT_TIMESTAMP) " +
            "GROUP BY STOCK_CODE " +
            "ORDER BY VIEW_CNT DESC", 
    countQuery = "SELECT COUNT(DISTINCT STOCK_CODE) FROM STOCK_VIEW_LOG",
    nativeQuery = true)
List<Object[]> findTopByViewTimeAfterOrderByViewCountDesc(Pageable pageable);
}