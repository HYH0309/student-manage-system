package com.example.hyh.mapper.manager;

import com.example.hyh.entity.manager.ShowTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeaShowMapper {
    @Select("SELECT tid, tname, tsex, tstatus,phone,address FROM teacher")
    List<ShowTeacher> findAllTeacher();
}
