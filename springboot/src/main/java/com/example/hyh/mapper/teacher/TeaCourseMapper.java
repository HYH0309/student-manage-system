package com.example.hyh.mapper.teacher;

import com.example.hyh.entity.teacher.Course;
import com.example.hyh.entity.teacher.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeaCourseMapper {
    @Select("""
        SELECT oc.oid as oid, c.courseName as courseName 
        FROM open_course oc
        JOIN course c ON oc.courseId = c.courseId
        WHERE oc.tid = #{tid}
    """)
    List<Course> selectAllCourse(int tid);

    @Select("SELECT cg.sid, cg.score, s.sname " +
            "FROM course_grade cg " +
            "JOIN student s ON cg.sid = s.sid " +
            "WHERE cg.oid = #{oid}")
    List<Grade> selectAllGrade(int oid);

    // 新增更新成绩的方法
    @Update("UPDATE course_grade " +
            "SET score = #{score} " +
            "WHERE oid = #{oid} AND sid = #{sid}")
    int updateGrade(int oid, int sid, double score);
}
