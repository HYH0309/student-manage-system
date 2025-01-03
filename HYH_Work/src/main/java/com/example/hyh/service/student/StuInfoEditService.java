package com.example.hyh.service.student;


import com.example.hyh.entity.Result;
import com.example.hyh.entity.student.StuInfoEdit;

public interface StuInfoEditService {
    Result stuinfoeditbycid(StuInfoEdit stuInfoEdit);

    boolean loadstuinfo(String address, String phone, int sid);
}