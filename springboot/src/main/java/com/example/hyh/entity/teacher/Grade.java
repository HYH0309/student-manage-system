package com.example.hyh.entity.teacher;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Grade {
    private int sid;
    private String sname;
    private Double score;
}
