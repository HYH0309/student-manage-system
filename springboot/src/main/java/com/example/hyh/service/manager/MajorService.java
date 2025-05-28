package com.example.hyh.service.manager;

import com.example.hyh.entity.manager.Major;

import java.util.List;

public interface MajorService {

    /**
     * 获取所有专业
     * @return 专业列表
     */
    List<Major> getAllMajors();

    /**
     * 根据 ID 获取特定专业
     * @param mid 专业 ID
     * @return 专业信息
     */
    Major getMajorById(int mid);

    /**
     * 创建新的专业
     * @param mname 专业名称
     * @param mdept 所属部门
     * @return 影响的行数
     */
    int createMajor(String mname, String mdept);

    /**
     * 更新专业信息
     * @param mid 专业 ID
     * @param mname 新的专业名称
     * @param mdept 新的所属部门
     * @return 影响的行数
     */
    int updateMajor(int mid, String mname, String mdept);

    /**
     * 删除专业
     * @param mid 专业 ID
     * @return 影响的行数
     */
    int deleteMajor(int mid);
}
