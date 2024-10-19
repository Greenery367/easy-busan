package com.easybusan.controller;

<<<<<<< HEAD
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

=======
import com.easybusan.utils.APIkey;
>>>>>>> ceeeed5ca6fe1d3be9a63e74ab52eff694d0bdc7
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
=======
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
>>>>>>> ceeeed5ca6fe1d3be9a63e74ab52eff694d0bdc7

@RestController
public class TransportationController {

    @GetMapping("/api/openApiForBus")
<<<<<<< HEAD
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

        String urlStr = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/6260000/BusanBIMS/busStopList")
        .queryParam("serviceKey", APIkey.DATA_PORTAL_ESH)
        .queryParam("pageNo", "1")      // 페이지 번호
        .queryParam("numOfRows", "1000")  // 결과 수
        .build(false)
        .toUriString();

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<MultiValueMap<String, String>> info = new HttpEntity<>(headers);

        // GET 요청 보내기
        ResponseEntity<BusStopResponse> response = restTemplate.exchange(urlStr, HttpMethod.GET, info, BusStopResponse.class);
        return response.getBody().toString();


    }
}