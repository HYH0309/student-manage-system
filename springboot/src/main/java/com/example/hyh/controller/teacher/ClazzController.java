
package com.example.hyh.controller.teacher;

import com.example.hyh.entity.teacher.Clazz;
import com.example.hyh.service.teacher.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api")
public class ClazzController {

    private final ClazzService clazzService;

    @Autowired
    public ClazzController(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    @PostMapping("/teacher/clazz")
    public ResponseEntity<?> getClassesByTeacherId(@RequestBody Map<String, Integer> requestData) {
        int tid = requestData.get("tid");
        List<Clazz> clazzes = clazzService.getClazzesByTeacherId(tid);

        Map<String, Object> response = new HashMap<>();
        response.put("code", true);
        response.put("data", clazzes);

        return ResponseEntity.ok(response);
    }
}
