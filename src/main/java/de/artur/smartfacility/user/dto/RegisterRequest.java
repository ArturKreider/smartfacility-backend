package de.artur.smartfacility.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

public class RegisterRequest {


    @NotBlank(message = "Name darf nicht leer sein")
    private String username;

    @NotBlank(message = "Email darf nicht leer sein")
    @Email(message = "keine gültige Email-Adresse")
    private String email;

    @NotBlank(message = "Passwort darf nicht leer sein")
    @Size(min = 4, max = 12, message = "Passwort muss zwischen 4 und 12 Zeichen lang sein")
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
