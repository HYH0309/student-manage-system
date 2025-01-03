package com.example.hyh.mapper.login;

import com.example.hyh.entity.login.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TeacherMapper {
    @Select("SELECT * FROM teacher WHERE tname = #{uname}")
    Teacher findByTeacher(String uname);

    @Insert("insert into teacher(tname,pswd)"+"values (#{uname},#{pwd})")
    void add(String uname, String pwd);

    @Update("UPDATE teacher SET pswd = #{pwd} WHERE tid = #{tid}")
    int updatePasswordByTid(int tid, String pwd);
}
