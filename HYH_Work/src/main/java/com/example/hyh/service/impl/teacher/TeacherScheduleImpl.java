package com.example.hyh.service.impl.teacher;

import com.example.hyh.entity.Schedule;
import com.example.hyh.entity.teacher.TeacherTime;
import com.example.hyh.mapper.teacher.TeaScheduleMapper;
import com.example.hyh.service.teacher.TeacherScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherScheduleImpl implements TeacherScheduleService {

    @Autowired
    private TeaScheduleMapper teacherScheduleMapper;  // Corrected mapper declaration

    @Override
    public String[][] findSchedule(TeacherTime teacherTime) {
        String[][] res = new String[5][10];

        List<Schedule> teacherSchedules = teacherScheduleMapper.getTeacherSchedules(teacherTime.getYear(), teacherTime.getTerm(), teacherTime.getTid());  // Correct method call
        for (Schedule schedule : teacherSchedules) {
            String weeknoStr = schedule.getWeekno();

            Boolean[] weekFlag = new Boolean[21];   // Conventionally boolean array name corrected
            for (int i = 0; i < weekFlag.length; i++) weekFlag[i] = false;  // Defensive Initialization

            int tmp = 0;
            for (int i = 0; i < weeknoStr.length(); i++) {
                char ch = weeknoStr.charAt(i);
                if (ch != ',') {    // Accumulate number until a comma
                    tmp = tmp * 10 + (ch - '0');
                } else {
                    weekFlag[tmp] = true;
                    tmp = 0;
                }
            }
            if (tmp > 0) weekFlag[tmp] = true;  // Adding the last number if there's no trailing comma

            if (!weekFlag[teacherTime.getWeekno()]) continue; // Filter schedules not in the current week

            int week = schedule.getWeek();
            int start = schedule.getStart();
            int size = schedule.getSize();
            String courseName = schedule.getCourseName();
            String rname = schedule.getRname();
            String tname = schedule.getTname();

            for (int j = 0; j < size; j++) {
                String str = courseName + "\n@" + rname + "\n" + tname;
                res[week - 1][start + j - 1] = str;
            }
        }

        return res;
    }
}
