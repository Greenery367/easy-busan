package com.easybusan.controller;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@RestController
public class InfraInfoController {

    private final String accessToken = "9e0f764a-5399-4754-afbd-85ad41205c8e";
    private final String sidoCd = "21";

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {
        Long accessTimeout;
        String accessToken;

    }

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResultToken {
        String id;
        Result result;
        String errMsg;
        Integer errCd;
        String trId;
    }

    // // 토큰 받아오기
    // @GetMapping("/token")
    // public String getToken() {

    // String conKey = "6a6fe44b3f5a41fdada6";
    // String conSecret = "10acdca3908c448080b3";

    // String apiUrl =
    // "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json"
    // + "?consumer_key=" + conKey
    // + "&consumer_secret=" + conSecret;

    // RestTemplate restTemplate = new RestTemplate();

    // try {
    // // String data = restTemplate.getForObject(apiUrl, String.class);
    // ResponseEntity<ResultToken> data = restTemplate.getForEntity(apiUrl,
    // ResultToken.class);
    // String resultStr = data.getBody().result.accessToken;

    // return ResponseEntity.ok(resultStr);
    // } catch (HttpClientErrorException e) {

    // return ResponseEntity.status(e.getStatusCode()).body("Error: " +
    // e.getMessage());
    // } catch (Exception e) {
    // System.out.println("----");
    // e.printStackTrace();
    // return ResponseEntity.status(500).body("Internal Server Error: " +
    // e.getMessage());
    // }
    // }

    // 백화점/중대형마트 학군 검색
    @GetMapping("/api/sggtoInfra")
    public List<Map<String, Object>> getSggToBrank() {

        String conKey = "6a6fe44b3f5a41fdada6";
        String conSecret = "10acdca3908c448080b3";
        String themeCd = "9001";
        // 9003 - 병원
        // 7001 - 초등학교
        // 7002 - 중학교
        // 7003 - 고등학교
        // 9001 - 백화점/중대형마트
        // 9004 - 극장/영화관
        // 9005 - 도서관/박물관
        // F001 - 체육시설

        String apiUrl1 = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json"
                + "?consumer_key=" + conKey
                + "&consumer_secret=" + conSecret;

        RestTemplate restTemplate1 = new RestTemplate();
        String resultStr=null;

        try {
            // String data = restTemplate.getForObject(apiUrl, String.class);
            ResponseEntity<ResultToken> response = restTemplate1.getForEntity(apiUrl1, ResultToken.class);
            resultStr = response.getBody().result.accessToken;
        } catch (Exception e) {
            System.out.println("----");
            e.printStackTrace();
        }


        String urlStr = UriComponentsBuilder
                .fromHttpUrl("https://sgisapi.kostat.go.kr/OpenAPI3/startupbiz/sggtobrank.json")
                .queryParam("accessToken", resultStr)
                .queryParam("sido_cd", sidoCd)
                .queryParam("theme_cd", themeCd)
                .build()
                .toUriString();
    RestTemplate restTemplate2 = new RestTemplate();
    List<Map<String, Object>> simplifiedInfoList = new ArrayList<>();
    List<Map<String, Object>> resultList = new ArrayList<>(); // 결과를 저장할 리스트

    
    try {
        // API 호출
        ResponseEntity<Map> response = restTemplate2.getForEntity(urlStr, Map.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> infraInfo = response.getBody();
            List<Map<String, Object>> sggInfoList = (List<Map<String, Object>>) ((Map<String, Object>) infraInfo.get("result")).get("sgg_info");

            if (sggInfoList != null) {
                // corp_cnt 기준 내림차순 정렬
                List<Map<String, Object>> sortedList = sggInfoList.stream()
                        .sorted((a, b) -> Integer.compare((Integer) b.get("corp_cnt"), (Integer) a.get("corp_cnt")))
                        .collect(Collectors.toList());

                // 순위를 매기고 결과를 리스트에 추가
                for (int i = 0; i < sortedList.size(); i++) {
                    Map<String, Object> sggInfo = sortedList.get(i);
                    Map<String, Object> rankInfo = new HashMap<>();
                    rankInfo.put("rank", i + 1);
                    rankInfo.put("sgg_nm", sggInfo.get("sgg_nm"));
                    rankInfo.put("corp_cnt", sggInfo.get("corp_cnt"));
                    resultList.add(rankInfo);
                }
            } else {
                return Collections.singletonList(Collections.singletonMap("error", "No sgg_info found in result."));
            }
        } else {
            return Collections.singletonList(Collections.singletonMap("error", "Error: " + response.getStatusCode()));
        }
    } catch (Exception e) {
        return Collections.singletonList(Collections.singletonMap("error", "Error during processing: " + e.getMessage()));
    }

    return resultList; // 리스트 반환
}



    // 애완동물 친화 시설
    @GetMapping("/petApi")
    @ResponseBody
    public String test() {
        RestTemplate rt1 = new RestTemplate();
        int count = 0;

        Map<String, Integer> numberList = new HashMap<>();
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>();

        // 페이지 반복 처리
        for (int i = 1; i < 15; i++) {
            String baseUrl = "https://api.odcloud.kr/api/15111389/v1/uddi:41944402-8249-4e45-9e9d-a52d0a7db1cc?serviceKey=unVv/4djC3M7YqhXbtokFfkTaIeuHr1HGAnKex5htS13RCMQxx9xdaCchb6NSEJIUs3Beua5JimsAwuZ0haOhg==&perPage=2000&page="
                    + i;
            ResponseEntity<Map> response1 = rt1.getForEntity(baseUrl, Map.class);

            Map<String, Object> responseBody = response1.getBody();

            // 필요한 필드가 리스트 형태로 있을 경우 처리
            if (responseBody != null && responseBody.get("data") instanceof Iterable) {
                Iterable<Map<String, Object>> data = (Iterable<Map<String, Object>>) responseBody.get("data");
                for (Map<String, Object> map : data) {
                    String sido = (String) map.get("시도 명칭");
                    String sigungu = (String) map.get("시군구 명칭");

                    // numberList에서 sigungu의 현재 값을 가져옵니다.
                    Integer currentCount = numberList.get(sigungu);
                    if (currentCount == null) {
                        // sigungu가 없으면 새로 추가합니다.
                        if (sido.contains("부산")) { // 부산일 때만 추가
                            numberList.put(sigungu, 1);
                        }
                    } else {
                        // sigungu가 있을 경우 +1 해줍니다.
                        numberList.put(sigungu, currentCount + 1);
                    }
                }

                // 값으로 정렬된 리스트 생성
                sortedEntries = new ArrayList<>(numberList.entrySet());
                sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue())); // 내림차순 정렬

                // sortedEntries = 순서대로 정렬된 리스트
            }
        }
        StringBuilder result = new StringBuilder();
        int rank = 1;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            result.append(": ").append(entry.getKey()).append(" (").append(entry.getValue()).append(")\n");
            rank++;
        }
        return result.toString();
    }

}
