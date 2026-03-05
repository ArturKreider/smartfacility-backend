package de.artur.smartfacility.room.dto;

public class RoomCreateRequest {

    private String name;
    private String floor;
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
