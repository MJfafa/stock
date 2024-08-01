프로젝트 개요
1. 서비스 설명
이 프로젝트는 실시간으로 순위 정보를 제공하는 API 서비스를 구현하는 것입니다. 서비스는 카카오페이 앱의 주식 서비스 내 "발견 탭"에서 제공되는 [TOP 주식] 서비스와 유사한 기능을 제공합니다. 주요 기능은 인기, 상승, 하락, 거래량 태그를 기준으로 주식을 필터링하고, 더보기 기능을 통해 관련 데이터를 더욱 자세히 확인할 수 있도록 합니다.

2. 요구사항
RESTful API 구현: 실시간 순위 서비스를 제공하는 RESTful API를 구현합니다.
기본 데이터 적재: 애플리케이션이 로딩될 때, 기본 데이터가 DB에 자동으로 적재되도록 합니다. 이를 위해 별도의 DB 사전작업 없이 애플리케이션만 실행하면 모든 데이터가 설정되어야 합니다.
효율적인 테이블 구조 설계: 데이터 테이블 구조는 효율적으로 설계해야 합니다.
단위 테스트 작성: 각 기능 및 제약사항에 대한 단위테스트를 작성해야 합니다.
기술 스택
언어: Java 8
프레임워크: Spring Boot 2.5.4
빌드 도구: Gradle
데이터베이스: H2 (In-Memory Database)
로깅: SLF4J, Logback
API 설명
1. 태그별 조회 API
인기(people-seen): 사람들이 많이 본 주식을 조회합니다.
상승(rising): 가격이 많이 오른 주식을 조회합니다.
하락(falling): 가격이 많이 내린 주식을 조회합니다.
거래량(volume): 거래량이 많은 주식을 조회합니다.
각 API는 페이징 기능을 제공하여, 요청 시점의 데이터를 기준으로 합니다.
2. 데이터 변경 API
랜덤 데이터 변경: 특정 태그의 대상이 되는 데이터를 랜덤으로 변경하여, 구현된 API를 테스트할 수 있습니다.
테이블 설계
1. STOCK_INFO 테이블
ID: 주식 정보의 고유 식별자
CODE: 주식 코드
NAME: 주식 이름
PRICE: 현재 가격
VOLUME: 거래량
SECTOR: 섹터
CHANGE_RATE: 가격 변동률
2. STOCK_DAILY_TRADE 테이블
TRADE_DATE: 거래 날짜
STOCK_CODE: 주식 코드
OPEN_PRICE: 시가
CLOSE_PRICE: 종가
HIGH_PRICE: 고가
LOW_PRICE: 저가
PRICE: 현재가
VOLUME: 거래량
구현 기능
1. 인기 주식 조회 API
http
GET /stocks/popular
EX)http://localhost:8080/stocks/popular?page=0&size=3
최근 한 시간 동안 조회수가 가장 많은 주식 정보를 반환합니다.
2. 상승률 상위 주식 조회 API
http
GET /stocks/top-rising
전일 종가 대비 당일 가격 상승률이 높은 순으로 주식 정보를 반환합니다.
3. 하락률 상위 주식 조회 API
http
GET /stocks/top-falling
전일 종가 대비 당일 가격 하락률이 높은 순으로 주식 정보를 반환합니다.
4. 거래량 상위 주식 조회 API
http
GET /stocks/volume
거래량이 가장 많은 주식 정보를 반환합니다.
테스트 케이스
1. 단위 테스트
각 기능의 정확한 동작을 보장하기 위해 다양한 단위 테스트가 작성되었습니다. 주요 테스트 항목은 다음과 같습니다.

주식 정보 조회 테스트: 주식 코드를 기반으로 주식 정보를 올바르게 반환하는지 테스트합니다.
일일 거래 내역 조회 테스트: 주식 코드별로 일일 거래 내역을 정확하게 반환하는지 확인합니다.
인기/상승/하락/거래량 주식 조회 테스트: API가 올바르게 주식 목록을 필터링하여 반환하는지 검증합니다.
2. 통합 테스트
애플리케이션의 전반적인 흐름이 정상적으로 작동하는지 통합 테스트를 통해 확인합니다.

빌드 및 실행 방법
1. 빌드
bash
gradlew clean build
2. 실행
bash
gradlew bootRun
애플리케이션은 기본적으로 http://localhost:8080에서 실행됩니다.

3. H2 데이터베이스 콘솔 접근
http
http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

결론 및 성능 고려사항
이 프로젝트는 실시간 주식 정보를 제공하기 위해 효율적인 데이터 처리와 API 설계가 이루어졌습니다. 서비스는 고부하 환경에서도 안정적으로 작동하도록 설계되었습니다. 이를 위해 데이터베이스와 API의 최적화에 많은 신경을 썼으며, 단위 테스트를 통해 각 기능의 신뢰성을 보장했습니다.
시간 관계상, 페이징 처리는 popular 만 구현했습니다. 

추후 확장 가능성을 고려하여 코드를 구조화하였으며, 더 많은 태그와 필터 기능을 추가할 수 있도록 유연하게 설계되었습니다.