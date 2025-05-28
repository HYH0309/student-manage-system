package com.example.hyh.service.student;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Map<String, Object>> getCourseGradeBySid(int sid);
}
