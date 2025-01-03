package com.example.hyh.service;

import com.example.hyh.entity.onlinejudge.Submission;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class OnlineJudgeService {

    private final String targetUrl = "http://47.92.90.228:2358/submissions";
    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> submitCode(Submission submission) {
        // 准备请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 准备请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("language_id", submission.getLanguageId());
        requestBody.put("source_code", submission.getCode());
        requestBody.put("stdin", submission.getInput());
        requestBody.put("expected_output", submission.getExpectedOutput());
        requestBody.put("cpu_time_limit", submission.getCpuTimeLimit());
        requestBody.put("memory_limit", submission.getMemoryLimit());

        // 将请求体转换为JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(500).body("{\"error\": \"Unable to process request\"}");
        }

        // 创建HttpEntity对象
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonResponse, headers);

        // 发送POST请求到目标URL
        return restTemplate.exchange(targetUrl, HttpMethod.POST, requestEntity, String.class);
    }

    public ResponseEntity<String> getCode(String token) {
        // 准备请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 使用UriComponentsBuilder来构建URL并添加查询参数
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(targetUrl + "/" + token)
                .queryParam("base64_encoded", "true");
        String urlWithParams = builder.toUriString();

        // 创建HttpEntity对象（对于GET请求，body通常为空）
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // 发送GET请求到目标URL
        return restTemplate.exchange(urlWithParams, HttpMethod.GET, requestEntity, String.class);
    }
}