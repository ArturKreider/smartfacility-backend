package de.artur.smartfacility.user.dto;

import de.artur.smartfacility.user.entity.Role;

public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private Role role;

    // Methoden

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return this.role;
    }
}
