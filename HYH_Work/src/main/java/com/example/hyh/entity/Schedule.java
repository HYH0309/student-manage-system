package com.example.hyh.entity;

import lombok.Data;

@Data
public class Schedule {
    private String weekno;
    private Integer week;
    private Integer start;
    private Integer size;
    private String courseName;
    private String rname;
    private String tname;
}
