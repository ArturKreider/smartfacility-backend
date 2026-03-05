package de.artur.smartfacility.building.api;

import de.artur.smartfacility.building.dto.BuildingCreateRequest;
import de.artur.smartfacility.building.dto.BuildingResponse;
import de.artur.smartfacility.building.service.BuildingService;
import de.artur.smartfacility.room.dto.RoomCreateRequest;
import de.artur.smartfacility.room.dto.RoomResponse;
import de.artur.smartfacility.room.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    private final BuildingService buildingService;
    private final RoomService roomService;

    public BuildingController(BuildingService buildingService, RoomService roomService) {
        this.buildingService = buildingService;
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<BuildingResponse> createBuilding(@RequestBody BuildingCreateRequest dto) {
        BuildingResponse response = buildingService.createBuilding(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{buildingId}/rooms")
    public ResponseEntity<RoomResponse> createRoomInBuilding(@PathVariable Long buildingId, @RequestBody RoomCreateRequest dto) {
        return roomService.createRoomInBuilding(buildingId, dto)
                .map(r -> ResponseEntity.ok(r))
                .orElse(ResponseEntity.notFound().build());
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
        return buildingService.getBuildingById(id)
                .map(b -> ResponseEntity.ok(b))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingResponse> updateBuilding(@PathVariable Long id, @RequestBody BuildingCreateRequest dto) {
        return buildingService.updateBuilding(id, dto)
                .map(b -> ResponseEntity.ok(b))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuilding(@PathVariable Long id) {
        boolean deletedBuilding = buildingService.deleteBuildingById(id);
        if (!deletedBuilding) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
