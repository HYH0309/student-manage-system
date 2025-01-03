
package com.example.hyh.mapper.manager;

import com.example.hyh.entity.manager.ShowStu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("SELECT sid, sname, sage, ssex,sstatus,phone,address FROM student")
    List<ShowStu> findAllStudents();
}