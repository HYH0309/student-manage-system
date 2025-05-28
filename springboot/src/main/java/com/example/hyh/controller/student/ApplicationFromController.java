package com.example.hyh.controller.student;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.student.ApplicationForm;
import com.example.hyh.service.student.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class ApplicationFromController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/student/approvalFrom")
    public Result submitApplication(@RequestBody ApplicationForm formData) {
        // 从请求体中获取提交的数据
        int sid = formData.getSid();
        String title = formData.getTitle();
        String reason = formData.getReason();
        String type = formData.getType();

        // 调用Service层中的方法进行数据插入
        return applicationService.Approvalfrom(sid, title, reason, type);
    }
}
