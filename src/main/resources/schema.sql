-- Drop constraints and tables if they exist
DROP TABLE IF EXISTS STOCK_VIEW_LOG CASCADE;
DROP TABLE IF EXISTS TRANSACTION_LEDGER CASCADE;
DROP TABLE IF EXISTS STOCK_TRADE_DETAIL CASCADE;
DROP TABLE IF EXISTS STOCK_DAILY_TRADE CASCADE;
DROP TABLE IF EXISTS USER CASCADE;
DROP TABLE IF EXISTS STOCK_INFO CASCADE;

CREATE TABLE USER (
    USER_ID VARCHAR(255) PRIMARY KEY,
    USER_NAME VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    REGISTRATION_DATE TIMESTAMP NOT NULL
);

CREATE TABLE STOCK_INFO (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CODE VARCHAR(50) NOT NULL,
    NAME VARCHAR(100) NOT NULL,
    PRICE DOUBLE NOT NULL,
    VOLUME BIGINT NOT NULL,
    SECTOR VARCHAR(100) NOT NULL,
    CHANGE_RATE DOUBLE
);

CREATE TABLE STOCK_DAILY_TRADE (	
    TRADE_DATE DATE NOT NULL,
    STOCK_CODE VARCHAR(50) NOT NULL,    
    PRICE DOUBLE NOT NULL,
    VOLUME BIGINT NOT NULL,
    PRIMARY KEY (TRADE_DATE, STOCK_CODE),
    FOREIGN KEY (STOCK_CODE) REFERENCES STOCK_INFO(CODE)
);


CREATE TABLE STOCK_TRADE_DETAIL (
    ID BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  -- ID 컬럼 자동 증가 설정
    TRADE_DATE DATE NOT NULL,
    USER_ID VARCHAR(255) NOT NULL,
    CODE VARCHAR(50) NOT NULL,
    TRADE_TYPE VARCHAR(50) NOT NULL,
    TRADE_VOLUME BIGINT NOT NULL,
    TRADE_PRICE DOUBLE NOT NULL,
    TRADE_TIME TIMESTAMP NOT NULL,    
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
    FOREIGN KEY (CODE) REFERENCES STOCK_INFO(CODE)
);




CREATE TABLE STOCK_VIEW_LOG (
    LOG_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    STOCK_CODE VARCHAR(50),
    VIEW_TIME TIMESTAMP NOT NULL,
    USER_ID VARCHAR(255),
    FOREIGN KEY (STOCK_CODE) REFERENCES STOCK_INFO(CODE),
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
);

CREATE TABLE TRANSACTION_LEDGER (
    LEDGER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    STOCK_CODE VARCHAR(50),
    TRADE_VOLUME INT NOT NULL,
    TRADE_PRICE DOUBLE NOT NULL,
    USER_ID VARCHAR(255),
    FOREIGN KEY (STOCK_CODE) REFERENCES STOCK_INFO(CODE),
    FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
);

