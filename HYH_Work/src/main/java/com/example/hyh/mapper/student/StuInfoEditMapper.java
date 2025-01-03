package com.example.hyh.mapper.student;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StuInfoEditMapper {

    @Update("UPDATE student SET address = #{address}, phone = #{phone} WHERE sid = #{sid}")
    void stuinfoedit(String address,  String phone, int sid);
}
