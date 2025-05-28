package com.example.hyh.mapper.student;

import com.example.hyh.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mapper
public interface StuScheduleMapper {

    Logger logger = LoggerFactory.getLogger(StuScheduleMapper.class);

    @Select("select ct.ctid, weekno, week, start, size, " +
            "(select courseName from course where course.courseId = oc.courseId) as courseName, " +
            "(select rname from room where room.rid = ct.rid) as rname, " +
            "(select tname from teacher where teacher.tid = oc.tid) as tname " +
            "from arrange_course ct, open_course oc " +
            "where ct.oid = oc.oid and year = #{year} and term = #{term} and cid = (select cid from clazz where cname = #{cname})")
    List<Schedule> selectStuSchedule(String year, String term, String cname);

}
