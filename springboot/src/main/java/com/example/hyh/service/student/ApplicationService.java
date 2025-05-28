package com.example.hyh.service.student;

import com.example.hyh.entity.Result;

public interface ApplicationService {
    Result Approvalfrom(int sid,String title,String reason,String type);
}
