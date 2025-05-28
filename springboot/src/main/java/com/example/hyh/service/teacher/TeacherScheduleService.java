package com.example.hyh.service.teacher;

import com.example.hyh.entity.teacher.TeacherTime;

public interface TeacherScheduleService {
    String[][] findSchedule(TeacherTime teacherTime);
}
