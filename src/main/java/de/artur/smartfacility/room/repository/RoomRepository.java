package de.artur.smartfacility.room.repository;

import de.artur.smartfacility.room.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    public Iterable<Room> findRoomsByBuildingId (Long buildingId);
}
