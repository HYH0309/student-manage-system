package com.example.hyh.service.impl.teacher;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.teacher.Course;
import com.example.hyh.entity.teacher.CourseWithGrades;
import com.example.hyh.entity.teacher.Grade;
import com.example.hyh.mapper.teacher.TeaCourseMapper;
import com.example.hyh.service.teacher.TeaCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeaCourseServiceImpl implements TeaCourseService {

    @Autowired
    private TeaCourseMapper teaCourseMapper;

    public List<Course> getCoursesByTeacherId(int tid) {
        return teaCourseMapper.selectAllCourse(tid);
    }

    public List<Grade> getGradesByCourseId(int oid) {
        return teaCourseMapper.selectAllGrade(oid);
    }

    public List<CourseWithGrades> getCoursesWithGrades(int tid) {
        List<Course> courses = getCoursesByTeacherId(tid);
        List<CourseWithGrades> result = new ArrayList<>();

        for (Course course : courses) {
            List<Grade> grades = getGradesByCourseId(course.getOid());
            result.add(new CourseWithGrades(course, grades));
        }
        return result;
    }
    public Result updateStudentGrade(int oid, int sid, double score) {
        int rowsAffected = teaCourseMapper.updateGrade(oid, sid, score);
        if (rowsAffected > 0) {
            return Result.success("成绩更新成功！");
        } else {
            return Result.error("成绩更新失败，可能找不到对应的记录。");
        }
    }
}