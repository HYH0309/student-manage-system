package com.example.hyh.service.impl.Login;

import com.example.hyh.entity.login.Login;
import com.example.hyh.entity.Result;
import com.example.hyh.entity.login.Teacher;
import com.example.hyh.mapper.login.TeacherMapper;
import com.example.hyh.service.login.TeacherService;
import com.example.hyh.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findByUser(String uname) {
        return teacherMapper.findByTeacher(uname);
    }

    @Override
    public void register(String uname, String pwd) {
        String encodedPassword = SecurityUtils.encodePassword(pwd);
        teacherMapper.add(uname, encodedPassword);
    }

    public boolean verifyUserPassword(String rawPassword, String encodedPassword) {
        return SecurityUtils.matchesPassword(rawPassword, encodedPassword);
    }

    public boolean existsByUsername(String uname) {
        return findByUser(uname) != null;
    }

    @Override
    public Result login(Login login) {

        if (!existsByUsername(login.getUsername()) ||
                !verifyUserPassword(login.getPassword(), findByUser(login.getUsername()).getPswd())) {
            return Result.error("用户名或密码错误");
        }

        return Result.success("登录成功");
    }
}
