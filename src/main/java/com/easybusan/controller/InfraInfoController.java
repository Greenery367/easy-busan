package com.easybusan.controller;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Result{
        Long accessTimeout;
        String accessToken;

    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultToken{
        String id;
        Result result;
        String errMsg;
        Integer errCd;
        String trId;
    }


    // 토큰 받아오기
    @GetMapping("/token")
    public ResponseEntity<String> getToken(){
        
        String conKey="6a6fe44b3f5a41fdada6";
        String conSecret="10acdca3908c448080b3";

        String apiUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json"
                + "?consumer_key=" + conKey
                + "&consumer_secret=" + conSecret;

        RestTemplate restTemplate = new RestTemplate();

        try {
            // String response = restTemplate.getForObject(apiUrl, String.class);
            ResponseEntity<ResultToken> response = restTemplate.getForEntity(apiUrl, ResultToken.class);
            String resultStr = response.getBody().result.accessToken;

            return ResponseEntity.ok(resultStr);
        } catch (HttpClientErrorException e) {

            return ResponseEntity.status(e.getStatusCode()).body("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("----");
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }



    // 인프라 검색
    @GetMapping("/api/sggtoInfra")
    public ResponseEntity<String> getSggToBrank(@RequestParam(name = "theme_cd") String themeCd) {

        

        String apiUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/startupbiz/sggtobrank.json"
                + "?accessToken=" + accessToken
                + "&sido_cd=" + sidoCd
                + "&theme_cd=" + themeCd;

        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(apiUrl, String.class);

            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException e) {

            return ResponseEntity.status(e.getStatusCode()).body("Error: " + e.getMessage());
        } catch (Exception e) {

            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }


}
