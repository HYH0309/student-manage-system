package com.example.hyh.entity.teacher;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInfo {
    private int tid;
    private String tsex;
    private String phone;
    private String address;
    private String coursename;
}
