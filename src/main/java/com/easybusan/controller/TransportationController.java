package com.easybusan.controller;

import java.util.List;
import java.util.Map;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import com.easybusan.controller.InfraInfoController.ResultToken;
import com.easybusan.dto.BusStopAreaDTO;
import com.easybusan.repository.model.BusStopResponse;
import com.easybusan.repository.model.BusStopResponse.Body;
import com.easybusan.repository.model.BusStopResponse.Body.Item;
import com.easybusan.utils.APIkey;

import org.locationtech.proj4j.BasicCoordinateTransform;
import org.locationtech.proj4j.CRSFactory;
import org.locationtech.proj4j.CoordinateReferenceSystem;
import org.locationtech.proj4j.ProjCoordinate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TransportationController {
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

    @GetMapping("/api/openApiForBus")
    public String getMethodName() throws UnsupportedEncodingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        // 버스 정류장 정보 받아오기
        List<Item> busstopList = new ArrayList<>();

        // 버스 정류장 정보 받아오기
        for (int pageNum = 1; pageNum < 10; pageNum++) {

            String urlStr = UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/6260000/BusanBIMS/busStopList")
                    .queryParam("serviceKey", APIkey.DATA_PORTAL_USH)
                    .queryParam("pageNo", pageNum) // 페이지 번호
                    .queryParam("numOfRows", "1000") // 결과 수
                    .build(false)
                    .toUriString();

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MultiValueMap<String, String>> info = new HttpEntity<>(headers);

            // GET 요청 보내기
            ResponseEntity<BusStopResponse> response = restTemplate.exchange(urlStr, HttpMethod.GET, info,
                    BusStopResponse.class);

            BusStopResponse busstopInfo = response.getBody();
            int size = busstopInfo.getBody().getItems().size();

            for (int a = 0; a < size; a++) {
                busstopList.add(busstopInfo.getBody().getItems().get(a));
            }
        }

        List<BusStopAreaDTO> busStopAreaList = new ArrayList<>();

        // 위치 API
        String secondUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json";

        // 토큰 발급
        String conKey = "e3e0b3201db741f4bf36";
        String conSecret = "894875f66ac0465e9fac";

        String apiUrl = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json"
                + "?consumer_key=" + conKey
                + "&consumer_secret=" + conSecret;

        RestTemplate restTemplate = new RestTemplate();
        String accessToken=null;

        try {
            // String response = restTemplate.getForObject(apiUrl, String.class);
            ResponseEntity<ResultToken> response = restTemplate.getForEntity(apiUrl, ResultToken.class);
            System.out.println("response: " + response);
            accessToken = response.getBody().result.accessToken;
            System.out.println("액세스토큰: " + accessToken);
            System.out.println("response: " + response);

        } catch (Exception e) {
            e.printStackTrace();
        }


        // 지역 변환(xy좌표->구군동)
        Map<String, Integer> count = new HashMap<>();
        for (int a = 0; a < busstopList.size(); a++) {

            String urlStr = UriComponentsBuilder
                    .fromHttpUrl("https://sgisapi.kostat.go.kr/OpenAPI3/addr/rgeocodewgs84.json")
                    .queryParam("accessToken", accessToken)
                    .queryParam("x_coor", busstopList.get(a).getGpsx())
                    .queryParam("y_coor", busstopList.get(a).getGpsy())
                    .queryParam("addr_type", 10)
                    .build()
                    .toUriString();
            RestTemplate restTemplate2 = new RestTemplate();
            ResponseEntity<Map> response = restTemplate2.getForEntity(urlStr, Map.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                Map<String, Object> busStopInfo = response.getBody();
                List<Map<String, Object>> results = (List<Map<String, Object>>) busStopInfo.get("result");
                if (results != null && !results.isEmpty()) {
                    String sgg = (String) results.get(0).get("sgg_nm");
                    count.put(sgg, count.getOrDefault(sgg, 0) + 1);
                } else {
                    // results가 null이거나 비어있을 때 처리
                    System.out.println("No results found for coordinates: " + busstopList.get(a).getGpsx() + ", "
                            + busstopList.get(a).getGpsy());
                }
                // 응답 처리
                System.out.println(count);
            } else {
                System.out.println("Error: " + response.getStatusCode());
            }
        }

    
    // 순위 매기기
    List<Map<String, Object>> rankedList = new ArrayList<>();
    count.entrySet().stream()
            .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue())) // 내림차순 정렬
            .forEach(entry -> {
                Map<String, Object> rankInfo = new HashMap<>();
                rankInfo.put("sgg_nm", entry.getKey());
                rankInfo.put("count", entry.getValue());
                rankedList.add(rankInfo);
            });

    // 순위 부여
    for (int i = 0; i < rankedList.size(); i++) {
        rankedList.get(i).put("rank", i + 1);
    }

    return rankedList.toString(); // 구 이름과 순위 리스트 반환
    }
}