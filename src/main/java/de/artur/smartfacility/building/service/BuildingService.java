package de.artur.smartfacility.building.service;

import de.artur.smartfacility.building.dto.BuildingCreateRequest;
import de.artur.smartfacility.building.dto.BuildingResponse;
import de.artur.smartfacility.building.entity.Building;
import de.artur.smartfacility.building.repository.BuildingRepository;
import de.artur.smartfacility.exception.BuildingNotFoundException;
import de.artur.smartfacility.exception.UserNotFoundException;
import de.artur.smartfacility.user.entity.User;
import de.artur.smartfacility.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final UserRepository userRepository;

    public BuildingService(BuildingRepository buildingRepository, UserRepository userRepository) {
        this.buildingRepository = buildingRepository;
        this.userRepository = userRepository;
    }


    // Methoden

    public BuildingResponse createBuilding(Long userId, BuildingCreateRequest dto) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("Der User wurde nicht gefunden");
        }
        User existingUser = optionalUser.get();
        Building building = mapToEntity(dto);
        building.setUser(existingUser);
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

    public BuildingResponse getBuildingById(Long buildingId) {
        Optional<Building> optionalBuilding = buildingRepository.findById(buildingId);
        if (optionalBuilding.isEmpty()) {
            throw new BuildingNotFoundException("Gebäude existiert nicht");
        }
        Building building = optionalBuilding.get();
        return mapToResponse(building);
    }

    public BuildingResponse updateBuilding(Long buildingId, BuildingCreateRequest dto) {
        Optional<Building> optionalBuilding = buildingRepository.findById(buildingId);
        if (optionalBuilding.isEmpty()) {
            throw new BuildingNotFoundException("Gebäude existiert nicht");
        }
        Building existingBuilding = optionalBuilding.get();

        existingBuilding.setName(dto.getName());
        existingBuilding.setAddress(dto.getAddress());

        Building updatedBuilding = buildingRepository.save(existingBuilding);
        return mapToResponse(updatedBuilding);
    }

    public void deleteBuildingById(Long id) {
        if (!buildingRepository.existsById(id)) {
            throw new BuildingNotFoundException("Gebäude existiert nicht");
        }
        buildingRepository.deleteById(id);
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
        response.setUserId(building.getUser().getId());
        return response;
    }
}
