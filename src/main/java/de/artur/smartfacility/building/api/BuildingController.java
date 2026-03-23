package de.artur.smartfacility.building.api;

import de.artur.smartfacility.building.dto.BuildingCreateRequest;
import de.artur.smartfacility.building.dto.BuildingResponse;
import de.artur.smartfacility.building.entity.Building;
import de.artur.smartfacility.building.service.BuildingService;
import de.artur.smartfacility.room.dto.RoomCreateRequest;
import de.artur.smartfacility.room.dto.RoomResponse;
import de.artur.smartfacility.room.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;
    private final RoomService roomService;

    public BuildingController(BuildingService buildingService, RoomService roomService) {
        this.buildingService = buildingService;
        this.roomService = roomService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<BuildingResponse> createBuilding(@PathVariable Long userId, @Valid @RequestBody BuildingCreateRequest dto) {
        BuildingResponse response = buildingService.createBuilding(userId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{buildingId}/rooms")
    public ResponseEntity<RoomResponse> createRoomInBuilding(@PathVariable Long buildingId, @Valid @RequestBody RoomCreateRequest dto) {
        RoomResponse response = roomService.createRoomInBuilding(buildingId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{buildingId}/rooms")
    public ResponseEntity<List<RoomResponse>> getRoomsByBuildingId(@PathVariable Long buildingId) {
        List<RoomResponse> responses = roomService.findRoomsByBuildingId(buildingId);
        return ResponseEntity.ok(responses);
    }


    @GetMapping
    public ResponseEntity<List<BuildingResponse>> getAllBuildings() {
        List<BuildingResponse> buildingResponses = buildingService.getAllBuildings();
        return ResponseEntity.ok(buildingResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingResponse> getBuildingById(@PathVariable Long id) {
        BuildingResponse response = buildingService.getBuildingById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingResponse> updateBuilding(@PathVariable Long id, @Valid @RequestBody BuildingCreateRequest dto) {
        BuildingResponse response = buildingService.updateBuilding(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        buildingService.deleteBuildingById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
