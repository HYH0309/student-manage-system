package com.example.hyh.service.impl.student;

import com.example.hyh.entity.student.StuInfo;
import com.example.hyh.mapper.student.StuInfoMapper;
import com.example.hyh.service.student.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuInfoServiceImpl implements StuInfoService {

    @Autowired
    private StuInfoMapper stuInfoMapper;

    public StuInfo findStuInfo(String uname) {
        return stuInfoMapper.findByStuinfo(uname);
    }
}
