package com.hotel.booking.service;

import com.hotel.booking.domain.Room;
import com.hotel.booking.dto.response.CreateRoomRequest;
import com.hotel.booking.exception.DuplicateResourceException;
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

    @Transactional
    public Room createRoom(CreateRoomRequest request) {

        if (roomRepository.existsByRoomNumber(request.getRoomNumber())) {
            throw new DuplicateResourceException(
                    "Room Number already exists with " + request.getRoomNumber()
            );
        }

        Room room = Room.builder()
                .roomNumber(request.getRoomNumber())
                .type(request.getType())
                .pricePerNight(request.getPricePerNight())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();
        room = roomRepository.save(room);
        log.info("Created Room No - {} | Type - {} ", room.getRoomNumber(), room.getType());

        return room;

    }


    public Room updateRoom(Long id, CreateRoomRequest request) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room with id - " + id + " Not found"));
        room.setRoomNumber(request.getRoomNumber());
        room.setCapacity(request.getCapacity());
        room.setType(request.getType());
        room.setDescription(request.getDescription());
        return roomRepository.save(room);
    }


}
