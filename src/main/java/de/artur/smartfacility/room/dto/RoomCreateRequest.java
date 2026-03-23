package de.artur.smartfacility.room.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class RoomCreateRequest {

    @NotBlank(message = "Raumname darf nicht leer sein")
    private String name;

    @NotBlank(message = "Etage darf nicht leer sein")
    private String floor;

    @Positive(message = "Größe muss größer 0 sein")
    private Double size;



    // Methoden

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setFloor(String floor){
        this.floor = floor;
    }

    public String getFloor(){
        return this.floor;
    }

    public void setSize(Double size){
        this.size = size;
    }

    public Double getSize(){
        return this.size;
    }
}
