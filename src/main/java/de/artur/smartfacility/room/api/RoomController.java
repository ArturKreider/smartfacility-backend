package de.artur.smartfacility.room.api;

import de.artur.smartfacility.room.dto.RoomCreateRequest;
import de.artur.smartfacility.room.dto.RoomResponse;
import de.artur.smartfacility.room.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        List<RoomResponse> responses = roomService.getAllRooms();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> GetRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .map(room -> ResponseEntity.ok(room))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@PathVariable Long id, @RequestBody RoomCreateRequest dto){
        return roomService.updateRoom(id, dto)
                .map(r -> ResponseEntity.ok(r))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
        boolean deletedRoom = roomService.deleteRoom(id);
        if(!deletedRoom){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
