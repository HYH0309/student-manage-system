package com.example.hyh.entity;

import lombok.Data;

@Data
public class Approval {
    private Integer sid;
    private String type;
    private String reason;
    private String sname; // 通过关联查询被引入

}