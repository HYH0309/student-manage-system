package com.example.hyh.controller.teacher;

import com.example.hyh.entity.Approval;
import com.example.hyh.service.teacher.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RestController
public class GetApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @GetMapping("/approvals")
    public ResponseEntity<?> getApprovals() {
        List<Approval>table=approvalService.getApprovalList();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", true); // 添加 code 属性
        responseMap.put("data", table);
        return ResponseEntity.ok(responseMap);
    }
}
