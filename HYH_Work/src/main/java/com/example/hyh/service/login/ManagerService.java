package com.example.hyh.service.login;

import com.example.hyh.entity.login.Login;
import com.example.hyh.entity.login.Manager;
import com.example.hyh.entity.Result;

public interface ManagerService {
    Manager findByUser(String uname);
    void register(String uname, String pwd);
    boolean existsByUsername(String uname);
    boolean verifyUserPassword(String rawPassword, String encodedPassword);
    Result login(Login login);
}
