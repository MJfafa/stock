package com.kakaopay.repository;

import com.kakaopay.model.StockInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on StockInfo entities.
 */
@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo, Long> {

    /**
     * Finds a stock by its code.
     * This method uses a custom JPQL query to retrieve a stock information by its code.
     *
     * @param code the stock code
     * @return an optional containing the stock if found
     */
    @Query(value = "SELECT * FROM STOCK_INFO WHERE CODE = ?1", nativeQuery = true)
    Optional<StockInfo> findByCode(String code);

    /**
     * Finds the top stocks by trading volume.
     * This method uses a custom JPQL query to retrieve stocks ordered by their trading volume in descending order.
     *
     * @return a list of stocks ordered by trading volume
     */

    @Query(value = "SELECT CODE, SUM(TRADE_VOLUME) AS VOL " +
            "FROM STOCK_TRADE_DETAIL " +
            "WHERE TRADE_DATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD') " +
            "GROUP BY CODE " +
            "ORDER BY VOL DESC", nativeQuery = true)
    List<Object[]> findTopByOrderByVolumeDesc();

    /**
     * Finds the top stocks by gain percentage.
     * This method uses a custom JPQL query to retrieve stocks ordered by their change rate in descending order,
     * which represents the gain percentage.
     *
     * @return a list of stocks ordered by gain percentage
     */
    @Query(value = "SELECT * FROM STOCK_INFO ORDER BY CHANGE_RATE DESC", nativeQuery = true)
    List<StockInfo> findTopByOrderByChangeRateDesc();

    /**
     * Finds the top stocks by loss percentage.
     * This method uses a custom JPQL query to retrieve stocks ordered by their change rate in ascending order,
     * which represents the loss percentage.
     *
     * @return a list of stocks ordered by loss percentage
     */
    @Query(value = "SELECT * FROM STOCK_INFO ORDER BY CHANGE_RATE ASC", nativeQuery = true)
    List<StockInfo> findTopByOrderByChangeRateAsc();

    /**
     * Finds stocks by their codes.
     * This method uses a custom JPQL query to retrieve multiple stocks whose codes are in the provided list.
     *
     * @param codes the list of stock codes
     * @return a list of stocks with the specified codes
     */
    @Query(value = "SELECT * FROM STOCK_INFO WHERE CODE IN (?1)", nativeQuery = true)
    List<StockInfo> findByCodeIn(List<String> codes);
}
