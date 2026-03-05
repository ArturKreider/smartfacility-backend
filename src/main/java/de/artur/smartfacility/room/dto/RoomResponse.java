package de.artur.smartfacility.room.dto;

public class RoomResponse {

    private Long id;
    private String name;
    private String floor;
    private Double size;
    private Long buildingId;


    // Methoden

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

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

    public void setBuildingId(Long buildingId){
        this.buildingId = buildingId;
    }
    public Long getBuildingId(){
        return this.buildingId;
    }
}
