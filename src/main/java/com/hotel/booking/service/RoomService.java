package com.hotel.booking.service;

import com.hotel.booking.domain.Room;
import com.hotel.booking.exception.ResourceNotFoundException;
import com.hotel.booking.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id - " + id));
    }


}
