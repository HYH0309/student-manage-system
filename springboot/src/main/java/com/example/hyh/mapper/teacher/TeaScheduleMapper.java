package com.example.hyh.mapper.teacher;

import com.example.hyh.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeaScheduleMapper {

    @Select("SELECT ct.ctid, weekno, week, start, size, " +
            "(SELECT courseName FROM course WHERE course.courseId = oc.courseId) AS courseName, " +
            "(SELECT rname FROM room WHERE room.rid = ct.rid) AS rname, " +
            "(SELECT tname FROM teacher WHERE teacher.tid = oc.tid) AS tname " +
            "FROM arrange_course ct JOIN open_course oc ON ct.oid = oc.oid " +
            "WHERE year = #{year} AND term = #{term} AND oc.tid = #{tid}")
    List<Schedule> getTeacherSchedules( String year, String term,  int tid);
}
