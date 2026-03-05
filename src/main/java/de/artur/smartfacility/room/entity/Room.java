package de.artur.smartfacility.room.entity;

import de.artur.smartfacility.building.entity.Building;
import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String floor;

    @Column(nullable = true)
    private Double size;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Building building;

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

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFloor() {
        return this.floor;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getSize() {
        return this.size;
    }

    public void setBuilding(Building building){
        this.building = building;
    }

    public Building getBuilding(){
        return this.building;
    }
}
