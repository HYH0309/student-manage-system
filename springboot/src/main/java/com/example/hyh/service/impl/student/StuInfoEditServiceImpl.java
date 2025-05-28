package com.example.hyh.service.impl.student;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.student.StuInfoEdit;
import com.example.hyh.mapper.student.StuInfoEditMapper;
import com.example.hyh.service.student.StuInfoEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuInfoEditServiceImpl implements StuInfoEditService {

    @Autowired
    private StuInfoEditMapper stuInfoEditMapper;

    @Override
    public Result stuinfoeditbycid(StuInfoEdit stuInfoEdit) {
        try {
            stuInfoEditMapper.stuinfoedit(stuInfoEdit.getAddress(), stuInfoEdit.getPhone(), stuInfoEdit.getSid());
            return new Result(true, "Student information updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "Failed to update student information");
        }
    }

    @Override
    public boolean loadstuinfo(String address, String phone, int sid) {
        try {
            stuInfoEditMapper.stuinfoedit(address, phone, sid);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
