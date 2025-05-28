package com.example.hyh.entity.student;

import lombok.Data;

@Data
public class ApplicationForm {
    private int sid; // 学生ID
    private String title; // 申请标题
    private String reason; // 申请理由
    private String type;  // 申请类型
}
