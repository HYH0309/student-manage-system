
package com.example.hyh.service.impl.teacher;

import com.example.hyh.entity.teacher.Clazz;
import com.example.hyh.mapper.teacher.ClazzMapper;
import com.example.hyh.service.teacher.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {


    private final ClazzMapper clazzMapper;

    @Autowired
    public ClazzServiceImpl(ClazzMapper clazzMapper) {
        this.clazzMapper = clazzMapper;
    }

    @Override
    public List<Clazz> getClazzesByTeacherId(int tid) {
        return clazzMapper.selectClazzesByTeacherId(tid);
    }
}