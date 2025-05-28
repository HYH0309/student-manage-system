package com.example.hyh.service.impl.manager;

import com.example.hyh.entity.manager.Room;
import com.example.hyh.mapper.manager.RoomMapper;
import com.example.hyh.service.manager.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    public List<Room> getAllRooms() {
        return roomMapper.findAllRooms();
    }

    public int createRoom(Room room) {
        return roomMapper.createRoom(room);
    }

    public void updateRoom(Room room) {
        roomMapper.updateRoom(room);
    }

    public void deleteRoom(int rid) {
        roomMapper.deleteRoom(rid);
    }
}
