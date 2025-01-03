package com.example.hyh.mapper.teacher;

import com.example.hyh.entity.teacher.Clazz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    @Select("SELECT c.cid, c.cname, c.mid, c.cremark, COUNT(s.sid) as studentCount " +
            "FROM clazz c " +
            "LEFT JOIN student s ON s.cid = c.cid " +
            "WHERE c.cid IN (SELECT cid FROM open_course WHERE tid = #{tid}) " +
            "GROUP BY c.cid, c.cname, c.mid, c.cremark")
    List<Clazz> selectClazzesByTeacherId(int teacherId);

}
