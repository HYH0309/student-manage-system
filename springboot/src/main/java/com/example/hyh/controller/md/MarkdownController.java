package com.example.hyh.controller.md;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api/markdown")
public class MarkdownController {

    @GetMapping("/file")
    public ResponseEntity<String> getMarkdownFile() {
        try {
            // 从 classpath 加载文件
            Resource resource = new ClassPathResource("static/search.md");
            Path path = resource.getFile().toPath();

            // 读取文件内容
            String content = Files.readString(path);

            // 返回文件内容
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            e.printStackTrace(); // 打印详细错误信息
            return ResponseEntity.internalServerError().body("Error loading Markdown file: " + e.getMessage());
        }
    }
}
