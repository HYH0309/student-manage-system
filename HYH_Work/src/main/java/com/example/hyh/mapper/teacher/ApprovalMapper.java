package com.example.hyh.mapper.teacher;

import com.example.hyh.entity.Approval;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApprovalMapper {

    @Select("SELECT approval.sid, approval.type, approval.reason, student.sname " +
            "FROM approval " +
            "JOIN student ON approval.sid = student.sid")
    List<Approval> getApprovalList();
}
