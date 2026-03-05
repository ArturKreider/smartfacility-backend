package de.artur.smartfacility.building.dto;

public class BuildingResponse {

    private Long id;
    private String name;
    private String address;

    //Methoden
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
}
