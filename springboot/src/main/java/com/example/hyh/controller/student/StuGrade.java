package com.example.hyh.controller.student;

import com.example.hyh.service.student.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class StuGrade {

    private final CourseService courseService;

    @Autowired
    public StuGrade(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/student/degrade")
    public ResponseEntity<?> grade(@RequestBody Map<String, Integer> requestData) {
        int sid = requestData.get("sid");
        List<Map<String, Object>> courseGrades = courseService.getCourseGradeBySid(sid);
        // 构建返回的数据模型，包含code字段
        Map<String, Object> response = new HashMap<>();
        response.put("code", true); // 设置code为true，表示成功
        response.put("data", courseGrades); // 将查询到的课程成绩信息放入data字段

        return ResponseEntity.ok(response);
    }
}
