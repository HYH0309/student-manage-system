package com.example.hyh.service.impl.Login;

import com.example.hyh.mapper.login.StuMapper;
import com.example.hyh.mapper.login.TeacherMapper;
import com.example.hyh.service.login.Updatepswd;
import com.example.hyh.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateImpl implements Updatepswd {

    private final StuMapper stuMapper;
    private final TeacherMapper teacherMapper;

    @Autowired
    public UpdateImpl(StuMapper stuMapper, TeacherMapper teacherMapper) {
        this.stuMapper = stuMapper;
        this.teacherMapper = teacherMapper;
    }
    @Override
    public boolean updateteapswd(String pswd, int tid) {
        String encodedPassword = SecurityUtils.encodePassword(pswd);
        int result = teacherMapper.updatePasswordByTid(tid,encodedPassword);
        return result>0;
    }

    @Override
    public boolean updatestupswd(String pswd, int sid) {
        String encodedPassword = SecurityUtils.encodePassword(pswd);
        int result = stuMapper.updatePasswordBySid(sid,encodedPassword);
        return result>0;
    }
}
