package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.web.RoomController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void addNewRoom(RoomController.RoomRepositoryRequestDTO roomDTO) {
        Room newRoom = new Room();
        newRoom.setCapacity(roomDTO.getCapacity());
        newRoom.setCode(roomDTO.getCode());

        roomRepository.save(newRoom);
    }

}
