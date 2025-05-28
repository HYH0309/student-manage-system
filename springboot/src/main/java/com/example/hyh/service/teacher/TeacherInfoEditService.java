package com.example.hyh.service.teacher;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.teacher.TeacherInfoEdit;

public interface TeacherInfoEditService {
    Result teacherinfoeditbytid(TeacherInfoEdit teacherInfoEdit);

    boolean loadteacherinfo(String address, String phone, int tid);
}
