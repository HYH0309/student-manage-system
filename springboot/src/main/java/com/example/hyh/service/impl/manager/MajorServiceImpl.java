package com.example.hyh.service.impl.manager;

import com.example.hyh.entity.manager.Major;
import com.example.hyh.mapper.manager.MajorMapper;
import com.example.hyh.service.manager.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> getAllMajors() {
        return majorMapper.findAllMajors();
    }

    @Override
    public Major getMajorById(int mid) {
        return majorMapper.findMajorById(mid);
    }

    @Override
    public int createMajor(String mname, String mdept) {
        return majorMapper.createMajor(mname, mdept);
    }

    @Override
    public int updateMajor(int mid, String mname, String mdept) {
        return majorMapper.updateMajor(mid, mname, mdept);
    }

    @Override
    public int deleteMajor(int mid) {
        return majorMapper.deleteMajor(mid);
    }
}
