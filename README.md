# 블로그 검색 API

## 빌드 결과물
- URL

## 실행 방법
- git clone https://github.com/poiuyy0420/demo.git
- ./gradlew clean build
- java -jar build/libs/demo-0.0.1-SNAPSHOT.jar

## API 명세
### 1. Swagger
- URL : http://localhost:8080/swagger

## 기능 정의

### 1. 블로그 검색
- 라이브러리 : spring-boot-starter-webflux
- Spring WebClient 사용하여 REST API (HTTP 통신) 사용
- 기존에 스프링에서 많이 사용하던 RestTemplate 보다 WebClient는 Single Thread와 Non-Blocking방식 네트워킹의 병목현상을 줄이고 성능을 향상시킵니다.
- 새로운 검색 API 추가 되어도 해당 인터페이스를 구현하여 사용할 수 있습니다. (KakaoBlogApi, NaverBlogApi)

### 2. 인기검색어 목록 조회
- 라이브러리 : pring-boot-starter-cache, ehcache, hibernate-jcache, cache-api
- ehCache3 적용으로 캐시 사용. 트래픽이 많고, 저장되어 있는 데이터가 많음을 염두에 둔 구현했습니다.
- @Scheduled 사용하여 1분마다 캐시 지워지게 구현 했습니다.

### 3. API 명세서 제공
- 라이브러리 : springdoc-openapi-ui
- REST API 문서화를 자동으로 만들어 주고 API 테스트가 가능합니다.