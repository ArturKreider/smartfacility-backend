package de.artur.smartfacility.room.service;

import de.artur.smartfacility.building.entity.Building;
import de.artur.smartfacility.building.repository.BuildingRepository;
import de.artur.smartfacility.room.dto.RoomCreateRequest;
import de.artur.smartfacility.room.dto.RoomResponse;
import de.artur.smartfacility.room.entity.Room;
import de.artur.smartfacility.room.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final BuildingRepository buildingRepository;

    public RoomService(RoomRepository roomRepository, BuildingRepository buildingRepository) {
        this.roomRepository = roomRepository;
        this.buildingRepository = buildingRepository;
    }


    //Methoden

    public Optional<RoomResponse> createRoomInBuilding(Long buildingId, RoomCreateRequest dto) {
        Room createRoom = mapToEntity(dto);
        Optional<Building> optionalBuilding = buildingRepository.findById(buildingId);
        if (optionalBuilding.isEmpty()) {
            return Optional.empty();
        }
        Building building = optionalBuilding.get();
        createRoom.setBuilding(building);
        Room savedRoom = roomRepository.save(createRoom);
        return Optional.of(mapToResponse(savedRoom));
    }

    public List<RoomResponse> getAllRooms() {
        Iterable<Room> rooms = roomRepository.findAll();
        List<RoomResponse> responses = new ArrayList<>();
        for (Room currentRoom : rooms) {
            responses.add(mapToResponse(currentRoom));
        }
        return responses;
    }

    public Optional<RoomResponse> getRoomById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) {
            return Optional.empty();
        }
        Room savedRoom = optionalRoom.get();
        return Optional.of(mapToResponse(savedRoom));
    }

    public List<RoomResponse> findRoomsByBuildingId(Long buildingId) {
        Iterable<Room> rooms  = roomRepository.findRoomsByBuildingId(buildingId);
        List<RoomResponse> responses = new ArrayList<>();
        for(Room currentRoom : rooms){
            responses.add(mapToResponse(currentRoom));
        }
        return responses;
    }

    public Optional<RoomResponse> updateRoom(Long id, RoomCreateRequest dto) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isEmpty()) {
            return Optional.empty();
        }
        Room savedRoom = optionalRoom.get();

        savedRoom.setName(dto.getName());
        savedRoom.setFloor(dto.getFloor());
        savedRoom.setSize(dto.getSize());

        Room updatedRoom = roomRepository.save(savedRoom);
        return Optional.of(mapToResponse(updatedRoom));
    }


    public boolean deleteRoom(Long id) {
        if (!roomRepository.existsById(id)) {
            return false;
        }
        roomRepository.deleteById(id);
        return true;
    }

    // Mapping
    private Room mapToEntity(RoomCreateRequest dto) {
        Room room = new Room();
        room.setName(dto.getName());
        room.setFloor(dto.getFloor());
        room.setSize(dto.getSize());
        return room;
    }

    private RoomResponse mapToResponse(Room room) {
        RoomResponse response = new RoomResponse();
        response.setId(room.getId());
        response.setName(room.getName());
        response.setFloor(room.getFloor());
        response.setSize(room.getSize());
        response.setBuildingId(room.getBuilding().getId());
        return response;
    }
}
