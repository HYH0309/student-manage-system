package com.example.hyh.mapper.teacher;

import com.example.hyh.entity.teacher.TeacherInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeachearInfoMapper {
    @Select("SELECT t.tid, t.tsex, t.phone, t.address, co.courseName as coursename FROM teacher t JOIN open_course oc ON t.tid = oc.tid JOIN course co ON oc.courseId = co.courseId WHERE t.tname = #{uname} Limit 1;")
    TeacherInfo findByTeachinfo(String uname);
}