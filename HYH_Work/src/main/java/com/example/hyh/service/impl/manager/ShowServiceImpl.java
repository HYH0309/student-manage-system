package com.example.hyh.service.impl.manager;

import com.example.hyh.entity.manager.ShowStu;
import com.example.hyh.entity.manager.ShowTeacher;
import com.example.hyh.mapper.manager.StudentMapper;
import com.example.hyh.mapper.manager.TeaShowMapper;
import com.example.hyh.service.manager.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeaShowMapper teaShowMapper;

    @Override
    public List<ShowStu> showstu() {
        return studentMapper.findAllStudents();
    }

    @Override
    public List<ShowTeacher> showteacher() {
        return teaShowMapper.findAllTeacher();
    }
}
