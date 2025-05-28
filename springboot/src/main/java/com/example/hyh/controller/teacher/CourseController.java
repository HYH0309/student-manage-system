package com.example.hyh.controller.teacher;


import com.example.hyh.entity.Result;
import com.example.hyh.entity.teacher.CourseWithGrades;
import com.example.hyh.service.teacher.TeaCourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class CourseController {

    @Autowired
    private TeaCourseService teaCourseService;

    @PostMapping("/teacher/course")
    public ResponseEntity<?> getCourseGrades(@RequestBody String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        int tid = jsonObject.optInt("tid");
        List<CourseWithGrades>table = teaCourseService.getCoursesWithGrades(tid);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", true); // 添加 code 属性
        responseMap.put("data", table); // 添加表格数据
        return ResponseEntity.ok().body(responseMap);
    }

    @PostMapping("/teacher/update_course")
    public Result updataCourseGrades(@RequestBody String jsonStr) {
        JSONObject jsonObject = new JSONObject(jsonStr);
        int sid = jsonObject.optInt("sid");
        int oid = jsonObject.optInt("oid");
        double score = jsonObject.optDouble("score");
        return  teaCourseService.updateStudentGrade(oid,sid,score);
    }

}
