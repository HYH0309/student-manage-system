package com.example.hyh.mapper.student;

import com.example.hyh.entity.student.StuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StuInfoMapper {
    @Select("SELECT s.sid, s.ssex, s.sage, s.phone, s.address, c.cname, m.mname, m.mdept " +
            "FROM student s " +
            "JOIN clazz c ON s.cid = c.cid " +
            "JOIN major m ON c.mid = m.mid " +
            "WHERE s.sname = #{uname}")
    StuInfo findByStuinfo(String uname);
}
