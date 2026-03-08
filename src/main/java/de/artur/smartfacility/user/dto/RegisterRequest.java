package de.artur.smartfacility.user.dto;

public class RegisterRequest {

    private String username;
    private String email;
    private String password;

    // Methoden

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

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
}
