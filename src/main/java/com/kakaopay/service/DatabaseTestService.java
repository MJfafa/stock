package com.kakaopay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List; // 이 줄을 추가
import java.util.Map; // 이 줄을 추가

@Service
public class DatabaseTestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void executeTestQuery() {
        String sql = "SELECT STOCK_CODE, COUNT(1) AS VIEW_CNT FROM STOCK_VIEW_LOG GROUP BY STOCK_CODE ORDER BY VIEW_CNT DESC";
        
        // 쿼리 실행 결과를 리스트로 받아옴
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

        // 결과를 로그에 출력
        if (results.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Map<String, Object> row : results) {
                System.out.println("Stock Code: " + row.get("STOCK_CODE") + ", View Count: " + row.get("VIEW_CNT"));
            }
        }
    }
}
