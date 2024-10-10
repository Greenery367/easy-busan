package com.easybusan.controller;

import com.easybusan.utils.APIDefine;
import com.easybusan.utils.APIUrl;
import com.easybusan.utils.APIkey;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
public class EstateAPIController {

    @GetMapping("api/estate")
    public String test() {
        RestTemplate rt1 = new RestTemplate();
        String baseURL = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < APIUrl.REAL_ESTATE_LIST.length; i++) {
            baseURL = APIUrl.REAL_ESTATE_LIST[i];
            for (int k = 0; k < APIDefine.LAWD_CD_LIST.length; k++) {

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
                        ResponseEntity<Map> response = rt1.getForEntity(uri, Map.class);
                        Map<String, Object> map = response.getBody();
                        Map<String, Object> responseMap = (Map<String, Object>) map.get("response");
                        Map<String, Object> body = (Map<String, Object>) responseMap.get("body");
                        Map<String, Object> items = (Map<String, Object>) body.get("items");
                        totalCount = Integer.parseInt(body.get("totalCount").toString());
                        totalPages = (int) Math.ceil((double) totalCount / numOfRows);
                        currentPage++;
                        Object itemObject = items.get("item");
                        if (itemObject instanceof List) {
                            // item이 여러 개일 때 (리스트일 경우)
                            List<Map<String, Object>> itemList = (List<Map<String, Object>>) itemObject;
                            for (Map<String, Object> item : itemList) {
                                sb.append(item.get("excluUseAr")).append(", ").append(item.get("dealAmount")).append("\n");
                            }
                        } else if (itemObject instanceof Map) {
                            // item이 하나일 때 (객체일 경우)
                            Map<String, Object> item = (Map<String, Object>) itemObject;
                            sb.append(item.get("excluUseAr")).append(", ").append(item.get("dealAmount")).append("\n");
                        }
                    } while (currentPage <= totalPages);
                }
            }
        }

        return sb.toString();
    }

}
