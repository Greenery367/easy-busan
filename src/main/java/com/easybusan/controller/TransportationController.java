package com.easybusan.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.easybusan.repository.model.BusStopResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TransportationController {

    @GetMapping("/api/openApiForBus")
    public String getMethodName() {
        System.out.println("11111");
        String urlEncodedKey="a";

        try {
            
            String decodedKey = "Iz9D02y9TpQoD9CSKLJAKif6yG4eipRdhOaSJoJHf30DkWo2BQA4qSfEHHGti%2F9Tnt30ZUMCLeNr2qiS3gZEXw%3D%3D";
            urlEncodedKey = URLEncoder.encode(decodedKey, StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        System.out.println(urlEncodedKey);

        String urlStr = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/6260000/BusanBIMS/busStopList")
        .queryParam("serviceKey",urlEncodedKey)
        .queryParam("pageNo", "1")      // 페이지 번호
        .queryParam("numOfRows", "1000")  // 결과 수
        .build(false)
        .toUriString();

        System.out.println(urlStr);

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String, String>> info = new HttpEntity<>(headers);

        // GET 요청 보내기
        ResponseEntity<String> response = restTemplate.exchange(urlStr, HttpMethod.GET, info, String.class);
        return response.getBody().toString();

        // Map<String, Object> responseBody = response.getBody();


        //   // 필요한 필드가 리스트 형태로 있을 경우 처리
        //   if (responseBody != null && responseBody.get("data") instanceof Iterable) {
        //     Iterable<Map<String, Object>> data = (Iterable<Map<String, Object>>) responseBody.get("data");
        //     for (Map<String, Object> map : data) {
        //        String sido = (String) map.get("시도 명칭"); 
        //        String sigungu = (String) map.get("시군구 명칭"); 

        //        // 시도 명칭이 "부산광역시"이고 시군구 명칭이 "사하구"일 경우 카운트 증가
        //        if ("부산광역시".equals(sido) && "사하구".equals(sigungu)) { // 사하구 부분을 사용자 입력한 값으로 받도록 변경
        //           count++; 
        //        }
        //     }

    }
}