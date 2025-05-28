package com.example.hyh.service.manager;


import com.example.hyh.entity.manager.ShowStu;
import com.example.hyh.entity.manager.ShowTeacher;

import java.util.List;

public interface ShowService {
    public List<ShowStu> showstu();
    public List<ShowTeacher> showteacher();
}
