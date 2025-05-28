package com.example.hyh.entity.manager;

import lombok.Data;

@Data
public class Room {
    private int rid; // 房间ID，主键
    private String rname; // 房间名称
    private int capacity;  // 房间容量
    private String remark; // 备注
}
