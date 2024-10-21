package com.easybusan.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class ApiController {

    private final String accessToken = "e067cca4-a42d-4ed4-856c-ae43b3dc0d2b";
    private final String sidoCd = "21";  

    @GetMapping("/api/sggtobrank")
    public ResponseEntity<String> getSggToBrank(
            @RequestParam(name = "theme_cd") String themeCd) {

        
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