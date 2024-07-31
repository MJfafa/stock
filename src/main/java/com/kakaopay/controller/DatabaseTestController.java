package com.kakaopay.controller;

import com.kakaopay.service.DatabaseTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseTestController {

    @Autowired
    private DatabaseTestService databaseTestService;

    @GetMapping("/test-query")
    public void testQuery() {
        databaseTestService.executeTestQuery();
    }
}
