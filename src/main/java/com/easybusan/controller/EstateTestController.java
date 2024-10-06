package com.easybusan.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class EstateTestController {

	@GetMapping("test")
	@ResponseBody
	public String test() {
		RestTemplate rt1 = new RestTemplate();
		String baseURL = "https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json";
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseURL)
			.queryParam("consumer_key", "dc8edee54b8a4cb297a1")
			.queryParam("consumer_secret", "b43aea3c2164417b89f7");
		ResponseEntity<Map> response1 = rt1.exchange(builder.toUriString(), HttpMethod.GET, null, Map.class);
		Map<String, Object> responseBody = response1.getBody();
		String accessToken = null;
		if (responseBody != null) {
			// "result" 객체를 추출
			Map<String, Object> result = (Map<String, Object>) responseBody.get("result");

			if (result != null) {
				// "accessToken" 값을 추출
				accessToken = (String) result.get("accessToken");
				System.out.println("AccessToken: " + accessToken);
			} else {
				System.out.println("Result가 존재하지 않습니다.");
			}
		} else {
			System.out.println("응답 바디가 null입니다.");
		}
		baseURL = "https://sgisapi.kostat.go.kr/OpenAPI3/stats/house.json";
		UriComponentsBuilder builder2 = UriComponentsBuilder.fromHttpUrl(baseURL)
			.queryParam("accessToken", accessToken)
			.queryParam("year", "2022")
			.queryParam("adm_cd", "21")
			.queryParam("low_search", "1")
			.queryParam("house_type", "01");
		ResponseEntity<String> response2 = rt1.exchange(builder2.toUriString(), HttpMethod.GET, null, String.class);
		return response2.getBody();
	}

}
