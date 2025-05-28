package com.example.hyh.controller.teacher;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.teacher.TeacherInfo;
import com.example.hyh.entity.teacher.TeacherInfoEdit;
import com.example.hyh.service.login.Updatepswd;
import com.example.hyh.service.teacher.TeacherInfoEditService;
import com.example.hyh.service.teacher.TeacherInfoService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class TeacherInfoController {

    @Autowired
    private TeacherInfoService teacherInfoService;

    @Autowired
    private TeacherInfoEditService teacherInfoEditService;

    @Autowired
    private Updatepswd updatepswd;

    private static final Logger logger = LoggerFactory.getLogger(TeacherInfoController.class);
    @PostMapping("/teacher/info")
    public ResponseEntity<?> teainfo(@RequestBody String jsonStr) {
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            String uname = jsonObj.getString("uname");

            TeacherInfo teacherInfo = teacherInfoService.findTeacherInfo(uname);
            JSONObject responseObj = new JSONObject();
            responseObj.put("code", true);
            responseObj.put("data", new JSONObject(teacherInfo));

            return ResponseEntity.ok().body(responseObj.toString());
        } catch (Exception e) {
            JSONObject responseObj = new JSONObject();
            responseObj.put("code", false);
            responseObj.put("msg", e.getMessage());
            return ResponseEntity.badRequest().body(responseObj.toString());
        }
    }
    @PostMapping("/teacher/info_edited")
    public Result teacherInfoEdited(@RequestBody TeacherInfoEdit edited) {
        return teacherInfoEditService.teacherinfoeditbytid(edited);
    }

    @PostMapping("/teacher/changePassword")
    public Result teapswdUpdate(@RequestBody String jsonStr){
        logger.debug("Extracted uname from JSON: {}", jsonStr);
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            String pswd = jsonObj.getString("pswd");
            int tid = jsonObj.getInt("tid");

            if(updatepswd.updateteapswd(pswd,tid)){
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