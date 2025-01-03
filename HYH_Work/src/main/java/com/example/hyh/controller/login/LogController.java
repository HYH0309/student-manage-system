package com.example.hyh.controller.login;

import com.example.hyh.entity.login.Login;
import com.example.hyh.entity.Result;
import com.example.hyh.service.login.ManagerService;
import com.example.hyh.service.login.StuService;
import com.example.hyh.service.login.TeacherService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.hyh.utils.Vercode.verifyCaptcha;

@RestController
@RequestMapping("/api")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class LogController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StuService stuService;

    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @PostMapping("/register")
    public Result register(@RequestBody Login login, HttpSession session) {
        if (Boolean.FALSE.equals(verifyCaptcha(login.getCaptcha(), session))) {
            logger.info("Wrong Captcha: {}", login.getCaptcha());
            return Result.error("验证码错误或已过期");
        }

        switch (login.getRole().toLowerCase()) {
            case "manager":
                if(managerService.existsByUsername(login.getUsername())) {
                    return Result.error("用户名已被占用");
                }
                managerService.register(login.getUsername(), login.getPassword());
                break;
            case "teacher":
                if(teacherService.existsByUsername(login.getUsername())) {
                    return Result.error("用户名已被占用");
                }
                teacherService.register(login.getUsername(),login.getPassword());
                break;
            case "student":
                if(stuService.existsByUsername(login.getUsername())) {
                    return Result.error("用户名已被占用");
                }
                stuService.register(login.getUsername(),login.getPassword());
                break;
            default:
                return Result.error("无效的用户角色");
        }

        return Result.success("注册成功！");
    }

    @PostMapping("/login")
    public Result login(@RequestBody Login login, HttpSession session) {
        if (Boolean.FALSE.equals(verifyCaptcha(login.getCaptcha(), session))) {
            return Result.error("验证码错误或已过期");
        }

        // Handle login based on role
        return switch (login.getRole().toLowerCase()) {
            case "manager" -> managerService.login(login);
            case "teacher" -> teacherService.login(login);
            case "student" -> stuService.login(login);
            default -> Result.error("无效的用户角色");
        };
    }
}
