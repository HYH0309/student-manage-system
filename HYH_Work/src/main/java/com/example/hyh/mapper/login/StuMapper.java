package com.example.hyh.mapper.login;

import com.example.hyh.entity.login.Stu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StuMapper {
    @Select("SELECT * FROM student WHERE sname = #{uname}")
    Stu findByStu(String uname);

    @Insert("insert into student(sname,pswd)"+"values (#{uname},#{pwd})")
    void add(String uname, String pwd);

    @Update("UPDATE student SET pswd = #{pwd} WHERE sid = #{sid}")
    int updatePasswordBySid(int sid, String pwd);
}
