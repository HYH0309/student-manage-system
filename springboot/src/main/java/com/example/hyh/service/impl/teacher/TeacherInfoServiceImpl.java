package com.example.hyh.service.impl.teacher;

import com.example.hyh.entity.teacher.TeacherInfo;
import com.example.hyh.mapper.teacher.TeachearInfoMapper;
import com.example.hyh.service.teacher.TeacherInfoService;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoServiceImpl implements TeacherInfoService {

    private final TeachearInfoMapper teachearInfoMapper;

    public TeacherInfoServiceImpl(TeachearInfoMapper teachearInfoMapper) {
        this.teachearInfoMapper = teachearInfoMapper;
    }
    @Override
    public TeacherInfo findTeacherInfo(String uname) {
        return teachearInfoMapper.findByTeachinfo(uname);
    }
}
