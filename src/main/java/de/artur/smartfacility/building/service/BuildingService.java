package de.artur.smartfacility.building.service;

import de.artur.smartfacility.building.dto.BuildingCreateRequest;
import de.artur.smartfacility.building.dto.BuildingResponse;
import de.artur.smartfacility.building.entity.Building;
import de.artur.smartfacility.building.repository.BuildingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }


    // Methoden

    public BuildingResponse createBuilding(BuildingCreateRequest dto) {
        Building building = mapToEntity(dto);
        Building savedBuilding = buildingRepository.save(building);
        return mapToResponse(savedBuilding);
    }

    public List<BuildingResponse> getAllBuildings() {
        Iterable<Building> buildingList = buildingRepository.findAll();
        List<BuildingResponse> buildingResponses = new ArrayList<>();
        for (Building currentBuilding : buildingList) {
            buildingResponses.add(mapToResponse(currentBuilding));
        }
        return buildingResponses;
    }

    public Optional<BuildingResponse> getBuildingById(Long id) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isEmpty()) {
            return Optional.empty();
        }
        Building building = optionalBuilding.get();
        BuildingResponse response = mapToResponse(building);
        return Optional.of(response);
    }

    public Optional<BuildingResponse> updateBuilding(Long id, BuildingCreateRequest dto) {
        Optional<Building> optionalBuilding = buildingRepository.findById(id);
        if (optionalBuilding.isEmpty()) {
            return Optional.empty();
        }
        Building existingBuilding = optionalBuilding.get();

        existingBuilding.setName(dto.getName());
        existingBuilding.setAddress(dto.getAddress());

        Building updatedBuilding = buildingRepository.save(existingBuilding);
        BuildingResponse buildingResponse = mapToResponse(updatedBuilding);
        return Optional.of(buildingResponse);
    }

    public boolean deleteBuildingById(Long id) {
        if (!buildingRepository.existsById(id)) {
            return false;
        }
        buildingRepository.deleteById(id);
        return true;
    }


    // Mapping
    private Building mapToEntity(BuildingCreateRequest dto) {
        Building building = new Building();
        building.setName(dto.getName());
        building.setAddress(dto.getAddress());
        return building;
    }

    private BuildingResponse mapToResponse(Building building) {
        BuildingResponse response = new BuildingResponse();
        response.setId(building.getId());
        response.setName(building.getName());
        response.setAddress(building.getAddress());
        return response;
    }
}
