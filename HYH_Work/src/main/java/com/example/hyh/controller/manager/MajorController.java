package com.example.hyh.controller.manager;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.manager.Major;
import com.example.hyh.service.manager.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api/majors")
public class MajorController {

    @Autowired
    private MajorService majorService;

    // 获取所有专业
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllMajors() {
        List<Major> majors = majorService.getAllMajors();
        Map<String, Object> response = new HashMap<>();
        response.put("code", true);
        response.put("data", majors);
        return ResponseEntity.ok(response);
    }

    // 创建新的专业
    @PostMapping("/add")
    public Result createMajor(@RequestBody Major major) {
        try {
            majorService.createMajor(major.getMname(), major.getMdept());
            return Result.success("成功");
        } catch (Exception e) {
            // 在这里您可以记录异常信息，或进行其他处理
            return Result.error("创建专业时出现错误: " + e.getMessage());
        }
    }

    @PutMapping("/{mid}")
    public Result updateMajor(@PathVariable("mid") int mid, @RequestBody Major major) {
        try {
            if (majorService.updateMajor(mid, major.getMname(), major.getMdept()) > 0) {
                return Result.success("更新成功");
            } else {
                return Result.error("未找到指定的专业或更新失败");
            }
        } catch (Exception e) {
            // 记录异常信息或处理其他逻辑
            return Result.error("更新专业时出现错误: " + e.getMessage());
        }
    }

    // 删除专业
    @DeleteMapping("/{mid}")
    public Result deleteMajor(@PathVariable("mid") int mid) {
        try {
            if (majorService.deleteMajor(mid) > 0) {
                return Result.success("删除成功");
            } else {
                return Result.error("未找到指定的专业");
            }
        } catch (Exception e) {
            return Result.error("删除专业时出现错误: " + e.getMessage());
        }
    }

}
