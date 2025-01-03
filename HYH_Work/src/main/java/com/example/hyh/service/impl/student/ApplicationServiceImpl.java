package com.example.hyh.service.impl.student;

import com.example.hyh.entity.Result;
import com.example.hyh.mapper.student.ApplicationFromMapper;
import com.example.hyh.service.student.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private  ApplicationFromMapper applicationFromMapper;


    @Override
    public Result Approvalfrom(int sid, String title, String reason, String type) {
        try {
            int rowsAffected = applicationFromMapper.add(sid, title, reason, type);

            if (rowsAffected > 0) {
                // 插入成功
                return new Result(true, "成功插入数据");
            } else {
                // 插入失败
                return new Result(false, "插入数据失败");
            }
        } catch (Exception e) {
            // 插入失败，可以根据具体异常进行处理
            return new Result(false, "插入数据失败: " + e.getMessage());
        }
    }

}