package com.example.hyh.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class ProxyController {

    private final String targetUrl = "https://spark-api-open.xf-yun.com/v1/chat/completions";
    private final String apiKey = "Bearer gOLsBVKCNPoLeDdnJtfo:quCaqUMNpyuGplhzAyqG";

    @PostMapping("/chat")
    public ResponseEntity<Object> handleChatRequest(@RequestBody Object requestBody) {
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", apiKey);
        headers.add("Content-Type", "application/json");

        // Create HTTP entity
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);

        // Forward the request using RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate.exchange(
                targetUrl,
                HttpMethod.POST,
                entity,
                Object.class
        );

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}
