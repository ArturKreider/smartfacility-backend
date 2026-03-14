package de.artur.smartfacility.building.repository;

import de.artur.smartfacility.building.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BuildingRepository extends CrudRepository<Building, Long> {

    public boolean existsById (Long buildingId);
}
