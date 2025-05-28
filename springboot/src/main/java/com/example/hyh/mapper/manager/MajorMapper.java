package com.example.hyh.mapper.manager;

import com.example.hyh.entity.manager.Major;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MajorMapper {

    @Select("SELECT mid, mname, mdept FROM major")
    List<Major> findAllMajors();

    @Select("SELECT mid, mname, mdept FROM major WHERE mid = #{mid}")
    Major findMajorById( int mid);

    @Insert("INSERT INTO major (mname, mdept) VALUES (#{mname}, #{mdept})")
    int createMajor( String mname, String mdept);

    @Update("UPDATE major SET mname = #{mname}, mdept = #{mdept} WHERE mid = #{mid}")
    int updateMajor( int mid,  String mname, String mdept);

    @Delete("DELETE FROM major WHERE mid = #{mid}")
    int deleteMajor( int mid);
}