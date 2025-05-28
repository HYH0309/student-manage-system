package com.example.hyh.controller.manager;

import com.example.hyh.entity.manager.ShowStu;
import com.example.hyh.entity.manager.ShowTeacher;
import com.example.hyh.service.manager.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class ShowController {

    @Autowired
    private ShowService  showService;

    @GetMapping("/student/show")
    public ResponseEntity<?> showstu() {
        List<ShowStu> show = showService.showstu();
        // 构建返回的数据模型，包含code字段
        Map<String, Object> response = new HashMap<>();
        response.put("code", true); // 设置code为true，表示成功
        response.put("data", show); // 将查询到的课程成绩信息放入data字段

        return ResponseEntity.ok(response);
    }

    @GetMapping("/teacher/show")
    public ResponseEntity<?> showtea() {
        List<ShowTeacher> show = showService.showteacher();
        // 构建返回的数据模型，包含code字段
        Map<String, Object> response = new HashMap<>();
        response.put("code", true); // 设置code为true，表示成功
        response.put("data", show); // 将查询到的课程成绩信息放入data字段

        return ResponseEntity.ok(response);
    }
}