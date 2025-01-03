package com.example.hyh.mapper.login;

import com.example.hyh.entity.login.Manager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManagerMapper {
    @Select("SELECT * FROM manager WHERE mname = #{uname}")
    Manager findByManager(String uname);

    @Insert("insert into manager(mname,pswd)"+"values (#{uname},#{pwd})")
    void add(String uname, String pwd);
}
