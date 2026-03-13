package de.artur.smartfacility.building.dto;

public class BuildingResponse {

    private Long id;
    private String name;
    private String address;
    private Long userId;

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


    public void setUserId(Long userId){
        this.userId = userId;
    }
    public Long getUserId(){
        return this.userId;
    }
}
