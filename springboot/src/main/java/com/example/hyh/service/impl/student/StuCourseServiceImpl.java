package com.example.hyh.service.impl.student;

import com.example.hyh.mapper.student.StuCourseMapper;
import com.example.hyh.service.student.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StuCourseServiceImpl implements CourseService {

    @Autowired
    private StuCourseMapper stuCourseMapper;

    public List<Map<String, Object>> getCourseGradeBySid(int sid) {
        return stuCourseMapper.selectCourseGradeBySid(sid);
    }
}

