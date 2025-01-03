package com.example.hyh.service.student;


import com.example.hyh.entity.student.StuTime;

public interface StuScheduleService {
    String[][] findSchedule(StuTime stuTime);
}