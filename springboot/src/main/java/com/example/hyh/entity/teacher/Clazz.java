package com.example.hyh.entity.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private int cid;
    private String cname;
    private int mid;
    private String cremark;
    private int studentCount;

}
