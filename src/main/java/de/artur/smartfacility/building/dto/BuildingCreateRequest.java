package de.artur.smartfacility.building.dto;

import jakarta.validation.constraints.NotBlank;

public class BuildingCreateRequest {

    @NotBlank(message = "Gebäudename darf nicht leer sein")
    private String name;

    @NotBlank(message = "Adresse darf nicht leer sein")
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
