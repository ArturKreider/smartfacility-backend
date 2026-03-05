package de.artur.smartfacility.building.entity;

import de.artur.smartfacility.room.entity.Room;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Building {

    // Attribute

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String address;

    @OneToMany(mappedBy = "building")
    private List<Room> rooms;

    // Konstruktoren

    // Methoden

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

}
