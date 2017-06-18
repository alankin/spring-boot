package com.dh.demo.web;

import com.dh.demo.domain.Room;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addRoom(@RequestBody RoomRepositoryRequestDTO room) {
        roomService.addNewRoom(room);
    }

    //DTO
    public static class RoomRepositoryRequestDTO {
        private String code;
        private Integer capacity;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }
}
