package com.example.hyh.controller.student;

import com.example.hyh.entity.student.StuTime;
import com.example.hyh.service.student.StuScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class StuScheduleController {

    private static final Logger logger = LoggerFactory.getLogger(StuScheduleController.class);

    @Autowired
    private StuScheduleService service;

    /**
     * 获取课程表
     * @param stuTime 包含搜索参数的StuSchedule对象
     * @return 课程表的数组
     */
    @PostMapping("/student/schedule")
    public ResponseEntity<?> queryTable(@RequestBody StuTime stuTime) {
        try {
            String[][] table = service.findSchedule(stuTime);
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("code", true); // 添加 code 属性
            responseMap.put("table", table); // 添加表格数据
            return ResponseEntity.ok().body(responseMap);
        } catch (Exception e) {
            String errorMessage = "Failed to query table: " + e.getMessage();
            logger.error(errorMessage, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}
