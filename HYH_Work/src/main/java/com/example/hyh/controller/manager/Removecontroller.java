package com.example.hyh.controller.manager;

import com.example.hyh.entity.Result;
import com.example.hyh.service.manager.RemoveService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class Removecontroller {

    @Autowired
    private RemoveService removeService;


    @PostMapping("/student/remove")
    public Result removestu(@RequestBody String jsonStr) {
        JSONObject object = new JSONObject(jsonStr);
        int sid = object.getInt("sid");
        if(removeService.movestu(sid)){
            return Result.success("删除成功");
        }
        else{
            return Result.error("查无此人");
        }
    }

    @PostMapping("/teacher/remove")
    public Result removetea(@RequestBody String jsonStr) {
        JSONObject object = new JSONObject(jsonStr);
        int tid = object.getInt("tid");
        if(removeService.movetea(tid)){
            return Result.success("删除成功");
        }
        else{
            return Result.error("查无此人");
        }
    }
}
