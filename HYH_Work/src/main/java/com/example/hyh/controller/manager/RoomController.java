package com.example.hyh.controller.manager;

import com.example.hyh.entity.Result;
import com.example.hyh.entity.manager.Room;
import com.example.hyh.service.manager.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api/classrooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // 获取所有房间
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        Map<String, Object> response = new HashMap<>();
        response.put("code", true);
        response.put("data", rooms);
        return ResponseEntity.ok(response);
    }

    // 创建新房间
    @PostMapping
    public Result createRoom(@RequestBody Room room) {
        int result = roomService.createRoom(room);
        if (result > 0) {
            return Result.success("房间创建成功");
        } else {
            return Result.error("房间创建失败");
        }
    }

    // 更新房间信息
    @PutMapping("/{rid}")
    public Result updateRoom(@PathVariable int rid, @RequestBody Room room) {
        room.setRid(rid); // 确保房间ID是最新的

        // 调用服务层更新房间信息
        try {
            roomService.updateRoom(room);
            return Result.success("房间更新成功");
        } catch (Exception e) {
            // 可以记录异常日志，e.getMessage() 可以用于获取具体的异常信息
            return Result.error("房间更新失败: " + e.getMessage());
        }
    }

    // 删除房间
    @DeleteMapping("/{rid}")
    public ResponseEntity<Map<String, Object>> deleteRoom(@PathVariable int rid) {
        roomService.deleteRoom(rid);
        Map<String, Object> response = new HashMap<>();
        response.put("code", true);
        response.put("msg", "房间删除成功");
        return ResponseEntity.ok(response);
    }
}
