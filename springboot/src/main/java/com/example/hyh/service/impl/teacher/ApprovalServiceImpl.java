package com.example.hyh.service.impl.teacher;

import com.example.hyh.entity.Approval;
import com.example.hyh.mapper.teacher.ApprovalMapper;
import com.example.hyh.service.teacher.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalServiceImpl implements ApprovalService {

    @Autowired
    private ApprovalMapper approvalMapper;

    public List<Approval> getApprovalList() {
        return approvalMapper.getApprovalList();
    }
}
