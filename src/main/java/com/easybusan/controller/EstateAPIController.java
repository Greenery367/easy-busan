package com.easybusan.controller;

import com.easybusan.dto.EstateAPIDTO;
import com.easybusan.service.EstateRankService;
import com.easybusan.utils.APIDefine;
import com.easybusan.utils.APIkey;
import com.easybusan.utils.EstateAPIUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EstateAPIController {

    private final EstateRankService estateRankService;

    @GetMapping("api/estate")
    public String test(@RequestParam(name = "type") String type) {
        RestTemplate rt1 = new RestTemplate();
        String baseURL = EstateAPIUrl.MAP.get(type);
        StringBuilder sb = new StringBuilder();
        Map<String, Double> amount = new HashMap<>();
        Map<String, Double> amount2 = new HashMap<>();
        Map<String, Double> countMap1 = new HashMap<>();
        Map<String, Double> countMap2 = new HashMap<>();
        for (int k = 0; k < APIDefine.LAWD_CD_LIST.length; k++) {
            double sum = 0;
            double sum2 = 0;
            double count1 = 0;
            double count2 = 0;
            for (int j = 202405; j <= 202407; j++) {
                int currentPage = 1;
                int numOfRows = 10;
                int totalCount = 0;
                int totalPages = 0;
                do {
                    String uri = UriComponentsBuilder.fromHttpUrl(baseURL)
                            .queryParam("serviceKey", APIkey.DATA_PORTAL_KKH)
                            .queryParam("LAWD_CD", APIDefine.LAWD_CD_LIST[k])
                            .queryParam("DEAL_YMD", j)
                            .queryParam("pageNo", currentPage)  // 현재 페이지 설정
                            .queryParam("numOfRows", numOfRows)  // 페이지 당 데이터 수
                            .build(false)  // 인코딩하지 않음
                            .toUriString();
                    ResponseEntity<EstateAPIDTO> response = rt1.getForEntity(uri, EstateAPIDTO.class);
                    EstateAPIDTO dto = response.getBody();
                    totalCount = dto.getBody().getTotalCount();
                    totalPages = (int) Math.ceil((double) totalCount / numOfRows);
                    currentPage++;
                    for (EstateAPIDTO.Item item : dto.getBody().getItems()) {
                        if (item.getExcluUseAr() == 0) continue;
                        double dealAmount = 0;
                        double dealAmount2 = 0;
                        // 전용 면적이 30 미만일 경우 원룸으로 간주 -> 따로 계산
                        if (type.endsWith("RENT") && item.getExcluUseAr() < 30) continue;
                        // 월세일 경우
                        if (type.endsWith("RENT") && !item.getMontlyRent().equals("0")) {
                            dealAmount = Double.parseDouble(item.getMontlyRent().replace(",", ""));
                            count1++;
                            // 전세일 경우
                        } else if (type.endsWith("RENT") && item.getDeposit() != null) {
                            dealAmount2 = Double.parseDouble(item.getDeposit().replace(",", ""));
                            count2++;
                            // 매매일 경우
                        } else {
                            dealAmount = Double.parseDouble(item.getDealAmount().replace(",", ""));
                        }
                        sum += dealAmount / item.getExcluUseAr();
                        sum2 += dealAmount2 / item.getExcluUseAr();
                    }
                } while (currentPage <= totalPages);
            }
            amount.put(APIDefine.LAWD_CD_LIST[k], amount.getOrDefault(APIDefine.LAWD_CD_LIST[k], 0.0) + sum);
            amount2.put(APIDefine.LAWD_CD_LIST[k], amount2.getOrDefault(APIDefine.LAWD_CD_LIST[k], 0.0) + sum2);
            if (type.endsWith("RENT")) {
                countMap1.put(APIDefine.LAWD_CD_LIST[k], count1);
                countMap2.put(APIDefine.LAWD_CD_LIST[k], count2);
            } else {
                countMap1.put(APIDefine.LAWD_CD_LIST[k], countMap1.getOrDefault(APIDefine.LAWD_CD_LIST[k], 0.0) + 1);
            }
        }
        Map<String, Double> sortedMapAmount = amount.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())) // Value를 기준으로 정렬
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1, // 중복 key 해결
                        LinkedHashMap::new // 정렬된 결과를 LinkedHashMap에 저장
                ));
        Map<String, Integer> resultMapAmount = estateRankService.rankCalculate(sortedMapAmount);
        sb.append("amount").append("\n");
        resultMapAmount.forEach((k, v) -> {
            sb.append(k).append(" : ").append(v).append("\n");
        });
        Map<String, Double> sortedMapCount = countMap1.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())) // Value를 기준으로 정렬
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue(),
                        (e1, e2) -> e1, // 중복 key 해결
                        LinkedHashMap::new // 정렬된 결과를 LinkedHashMap에 저장
                ));
        Map<String, Integer> resultMapCount = estateRankService.rankCalculate(sortedMapCount);
        sb.append("count").append("\n");
        resultMapCount.forEach((k, v) -> {
            sb.append(k).append(" : ").append(v).append("\n");
        });
        if (type.endsWith("RENT")) {
            Map<String, Double> sortedMapAmount2 = amount2.entrySet()
                    .stream()
                    .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())) // Value를 기준으로 정렬
                    .collect(Collectors.toMap(
                            entry -> entry.getKey(),
                            entry -> entry.getValue(),
                            (e1, e2) -> e1, // 중복 key 해결
                            LinkedHashMap::new // 정렬된 결과를 LinkedHashMap에 저장
                    ));
            Map<String, Integer> resultMapAmount2 = estateRankService.rankCalculate(sortedMapAmount2);
            sb.append("amount2").append("\n");
            resultMapAmount.forEach((k, v) -> {
                sb.append(k).append(" : ").append(v).append("\n");
            });
            Map<String, Double> sortedMapCount2 = countMap2.entrySet()
                    .stream()
                    .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())) // Value를 기준으로 정렬
                    .collect(Collectors.toMap(
                            entry -> entry.getKey(),
                            entry -> entry.getValue(),
                            (e1, e2) -> e1, // 중복 key 해결
                            LinkedHashMap::new // 정렬된 결과를 LinkedHashMap에 저장
                    ));
            Map<String, Integer> resultMapCount2 = estateRankService.rankCalculate(sortedMapCount2);
            sb.append("count2").append("\n");
            resultMapCount.forEach((k, v) -> {
                sb.append(k).append(" : ").append(v).append("\n");
            });
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    @GetMapping("api/estate-oneroom")
    public String test2() {
        return null;
    }
}
