package com.easybusan.controller;

import com.easybusan.dto.EstateAPIDTO;
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
        int count = 0;
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
                        ResponseEntity<EstateAPIDTO> response = rt1.getForEntity(uri, EstateAPIDTO.class);
                        EstateAPIDTO dto = response.getBody();
                        totalCount = dto.getBody().getTotalCount();
                        totalPages = (int) Math.ceil((double) totalCount / numOfRows);
                        currentPage++;
                        for (EstateAPIDTO.Item item : dto.getBody().getItems()) {
                            sb.append(item.getExcluUseAr()).append(", ").append(item.getDealAmount()).append("\n");
                        }
                        System.out.println("URL : " + baseURL);
                        System.out.println("지역 코드 : " + APIDefine.LAWD_CD_LIST[k] + "년도 : " + j + " 횟수 : " + ++count);
                    } while (currentPage <= totalPages);
                }
            }
        }

        return sb.toString();
    }

}
