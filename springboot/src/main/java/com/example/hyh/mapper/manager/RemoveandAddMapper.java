package com.example.hyh.mapper.manager;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RemoveandAddMapper {
    @Delete("DELETE FROM student WHERE sid = #{sid}")
    int deleteBySid(int sid);

    @Delete("DELETE FROM teacher WHERE tid = #{tid}")
    int deleteByTid(int tid);
}
