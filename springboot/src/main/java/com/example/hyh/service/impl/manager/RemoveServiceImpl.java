package com.example.hyh.service.impl.manager;

import com.example.hyh.mapper.manager.RemoveandAddMapper;
import com.example.hyh.service.manager.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RemoveServiceImpl implements RemoveService {



    private final RemoveandAddMapper removeMapper;

    @Autowired
    public RemoveServiceImpl(RemoveandAddMapper removeMapper) {
        this.removeMapper = removeMapper;
    }

    @Override
    public boolean movetea(int tid) {
        int result = removeMapper.deleteByTid(tid);
        return result > 0 ;
    }

    @Override
    public boolean movestu(int sid) {
        int result = removeMapper.deleteBySid(sid);
        return result > 0 ;
    }
}
