package de.artur.smartfacility.building.dto;

public class BuildingCreateRequest {

    private String name;
    private String address;

    // Methoden

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
}
