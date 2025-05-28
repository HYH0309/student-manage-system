package com.example.hyh.service.impl.teacher;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.teacher.TeacherInfoEdit;
import com.example.hyh.mapper.teacher.TeacherInfoEditMapper;
import com.example.hyh.service.teacher.TeacherInfoEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoEditIServiceImpl implements TeacherInfoEditService {

    private  final TeacherInfoEditMapper teacherInfoEditMapper;

    @Autowired
    public TeacherInfoEditIServiceImpl(TeacherInfoEditMapper teacherInfoEditMapper) {
        this.teacherInfoEditMapper = teacherInfoEditMapper;
    }

    @Override
    public Result teacherinfoeditbytid(TeacherInfoEdit teacherInfoEdit) {
        try {
            teacherInfoEditMapper.teacherinfoedit(teacherInfoEdit.getAddress(),teacherInfoEdit.getPhone(),teacherInfoEdit.getTid());
            return new Result(true, "teacher information updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Failed to update teacher information");
        }
    }


    @Override
    public boolean loadteacherinfo(String address, String phone, int tid) {
        try {
            teacherInfoEditMapper.teacherinfoedit(address, phone, tid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
