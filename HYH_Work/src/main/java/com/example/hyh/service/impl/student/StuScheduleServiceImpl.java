package com.example.hyh.service.impl.student;

import com.example.hyh.entity.Schedule;
import com.example.hyh.entity.student.StuTime;
import com.example.hyh.mapper.student.StuScheduleMapper;
import com.example.hyh.service.student.StuScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuScheduleServiceImpl implements StuScheduleService {

    @Autowired
    StuScheduleMapper stuScheduleMapper;

    @Override
    public String[][] findSchedule(StuTime stuTime) {

        String[][] res = new String[5][10];

        List<Schedule> stuSchedules = stuScheduleMapper.selectStuSchedule(stuTime.getYear(),stuTime.getTerm(),stuTime.getCname());
        for (Schedule schedule : stuSchedules) {
            String weeknoStr = schedule.getWeekno();

            Boolean[] weekFLag = new Boolean[21];   //有的周数置真，否则置假
            for(int i = 0; i < 21; i++) weekFLag[i] = false;    //初始化

            int tmp = 0;
            for(int i = 0; i < weeknoStr.length(); i++) {
                if(weeknoStr.charAt(i) != ',') {    //不是逗号，进tmp
                    tmp = tmp * 10 + (weeknoStr.charAt(i) - '0');
                } else {    //遇到逗号就把tmp送给flag，tmp清零
                    weekFLag[tmp] = true;
                    tmp = 0;
                }
            }
            weekFLag[tmp] = true;   //扫尾

            if(Boolean.FALSE.equals(weekFLag[stuTime.getWeekno()])) continue; //如果当前周不在该排课周数集合里，那么跳过

            int week = schedule.getWeek();  //星期几
            int start = schedule.getStart();    //第几节课
            int size = schedule.getSize();  //课长
            String courseName = schedule.getCourseName();  //课程名
            String rname = schedule.getRname(); //教室名
            String tname = schedule.getTname(); //教师名

            for(int j = 0; j < size; j++) {
                String str = courseName + "\n@" + rname + "\n" + tname;
                res[week - 1][start + j - 1] = str;
            }
        }

        return res;
    }
}