package com.example.hyh.controller;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.onlinejudge.Submission;
import com.example.hyh.service.OnlineJudgeService;
import com.example.hyh.service.ResourceService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OnlineJudgeController {

    @Autowired
    private OnlineJudgeService onlineJudgeService;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private ResourceService resourceService;
    @PostMapping("/oj/submit")
    public ResponseEntity<String> judge(@RequestParam int language_id, @RequestParam String source_code, @RequestParam int tid) throws IOException {
        ObjectNode tokensNode = objectMapper.createObjectNode();  // 使用ObjectNode来构建JSON对象
        for (int i = 1; i <= 10; i++) {
            // 设定输入和输出文件路径
            String inputFilePath = String.format("classpath:test/%d/%d.in",tid,i);
            String outputFilePath = String.format("classpath:test/%d/%d.out",tid,i);

            try {
                String input = resourceService.readResourceFile(inputFilePath);
                String output = resourceService.readResourceFile(outputFilePath);

                // 构建提交对象
                Submission submission = new Submission();
                submission.setLanguageId(language_id);  // 从请求参数获取语言 ID
                submission.setCode(source_code);        // 从请求参数获取源代码
                submission.setInput(input);
                submission.setExpectedOutput(output);
                submission.setCpuTimeLimit(2); // 请替换为实际的时间限制
                submission.setMemoryLimit(128000); // 请替换为实际的内存限制

                // 发送请求并处理响应
                ResponseEntity<String> subresponse = onlineJudgeService.submitCode(submission);
                String res = subresponse.getBody();
                JsonNode jsonNode = objectMapper.readTree(res);
                String token = jsonNode.get("token").asText();
                tokensNode.put("token" + i, token);  // 如果使用对象，并将每个token标记为 "token1", "token2" 等
            } catch (Exception e) {
                return ResponseEntity.status(500).body("{\"error\": \"Error processing file for test case " + i + "\"}");
            }
        }
        try{
            String jsonTokensObject = objectMapper.writeValueAsString(tokensNode);
            return ResponseEntity.ok(jsonTokensObject);
        }catch (Exception e){
            return ResponseEntity.status(500).body("{\"error\": \"Failed to generate JSON output.\"}");
        }
    }
    @GetMapping("/oj/get")
    public Result getCode(@RequestParam String token) {
        ResponseEntity<String> responseEntity = onlineJudgeService.getCode(token);
        String responseBody = responseEntity.getBody();

        try {
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            String statusDescription = jsonNode.get("status").get("description").asText();

            if (statusDescription.equals("Accepted")) {
                return Result.success(statusDescription);
            }else return Result.error(statusDescription);
        } catch (Exception e) {
            throw new RuntimeException("Error processing JSON", e);
        }
    }
}