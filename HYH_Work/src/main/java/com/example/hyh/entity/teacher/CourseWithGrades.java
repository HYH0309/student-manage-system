package com.example.hyh.entity.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseWithGrades {
    private Course course;
    private List<Grade> grades;
}
