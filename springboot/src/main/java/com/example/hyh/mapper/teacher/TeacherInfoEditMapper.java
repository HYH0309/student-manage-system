package com.example.hyh.mapper.teacher;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherInfoEditMapper {

    @Update("UPDATE teacher SET address = #{address}, phone = #{phone} WHERE tid = #{tid}")
    void teacherinfoedit(String address,  String phone, int tid);
}

