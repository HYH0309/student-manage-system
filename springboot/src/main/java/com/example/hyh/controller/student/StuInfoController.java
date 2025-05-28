package com.example.hyh.controller.student;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.student.StuInfo;
import com.example.hyh.entity.student.StuInfoEdit;
import com.example.hyh.service.login.Updatepswd;
import com.example.hyh.service.student.StuInfoEditService;
import com.example.hyh.service.student.StuInfoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class StuInfoController {

    @Autowired
    private StuInfoService stuinfoService;

    @Autowired
    private StuInfoEditService stuInfoEditService;

    @Autowired
    private Updatepswd updatepswd;

    @PostMapping("/student/info")
    public ResponseEntity<?> stuInfo(@RequestBody String jsonStr) {
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            String uname = jsonObj.getString("uname");
            StuInfo studentInfo = stuinfoService.findStuInfo(uname);
            JSONObject responseObj = new JSONObject();
            responseObj.put("code", true); // 加个确认的代码，前端封装的拦截器需要
            responseObj.put("data", new JSONObject(studentInfo));
            return ResponseEntity.ok().body(responseObj.toString());
        } catch (Exception e) {
            JSONObject responseObj = new JSONObject();
            responseObj.put("code", false);
            responseObj.put("msg", e.getMessage()); // 可选吧，前端暂时没有
            return ResponseEntity.badRequest().body(responseObj.toString());
        }
    }
    @PostMapping("/student/info_edited")
    public Result stuInfoEdited(@RequestBody StuInfoEdit edited) {
        return stuInfoEditService.stuinfoeditbycid(edited);
    }

    @PostMapping("/student/changePassword")
    public Result stupswdUpdate(@RequestBody String jsonStr){
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            String pswd = jsonObj.getString("pswd");
            int sid = jsonObj.getInt("sid");
            if(updatepswd.updatestupswd(pswd,sid)){
                return Result.success("更新成功");
            }
            else{
                return Result.error("查无此人,请联系管理员");
            }
        } catch (Exception e) {
            return Result.error("更新失败，请联系管理员");
        }
    }
}