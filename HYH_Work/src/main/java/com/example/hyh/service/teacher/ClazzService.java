package com.example.hyh.service.teacher;

import com.example.hyh.entity.teacher.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> getClazzesByTeacherId(int tid);
}