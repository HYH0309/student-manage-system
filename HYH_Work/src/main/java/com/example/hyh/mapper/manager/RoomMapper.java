package com.example.hyh.mapper.manager;

import com.example.hyh.entity.manager.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoomMapper {

    @Select("SELECT rid, rname, capacity, remark FROM room")
    List<Room> findAllRooms();

    @Select("SELECT rid, rname, capacity, remark FROM room WHERE rid = #{rid}")
    Room findRoomById(int rid);

    @Insert("INSERT INTO room (rname, capacity, remark) VALUES (#{rname}, #{capacity}, #{remark})")
    int createRoom(Room room);

    @Update("UPDATE room SET rname = #{rname}, capacity = #{capacity}, remark = #{remark} WHERE rid = #{rid}")
    int updateRoom(Room room);

    @Delete("DELETE FROM room WHERE rid = #{rid}")
    int deleteRoom(int rid);
}
