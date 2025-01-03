package com.example.hyh.mapper.student;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApplicationFromMapper {

    @Insert("insert into approval(sid, title, reason, type) values (#{sid}, #{title}, #{reason}, #{type})")
    int add(int sid, String title, String reason, String type);
}
