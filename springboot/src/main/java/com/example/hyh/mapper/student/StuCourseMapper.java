package com.example.hyh.mapper.student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StuCourseMapper {

    @Select("SELECT oc.year, oc.term, oc.tid, oc.courseId, oc.remark, cg.score, c.courseName, t.tname " +
            "FROM open_course oc " +
            "INNER JOIN course_grade cg ON oc.oid = cg.oid " +
            "INNER JOIN course c ON oc.courseId = c.courseId " +
            "INNER JOIN teacher t ON oc.tid = t.tid " +
            "WHERE cg.sid = #{sid}")

    List<Map<String, Object>> selectCourseGradeBySid( int sid);
}