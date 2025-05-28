package com.example.hyh.service.manager;

import com.example.hyh.entity.manager.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    int createRoom(Room room);
    void updateRoom(Room room);
    void deleteRoom(int id);
}
