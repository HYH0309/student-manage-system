package com.example.hyh.service.teacher;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.teacher.CourseWithGrades;

import java.util.List;

public interface TeaCourseService {
    List<CourseWithGrades> getCoursesWithGrades(int tid);
    Result updateStudentGrade(int oid, int sid, double score);
}
