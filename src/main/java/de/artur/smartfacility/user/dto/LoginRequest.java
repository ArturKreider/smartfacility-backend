package de.artur.smartfacility.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "Email darf nicht leer sein")
    @Email(message = "keine gültige Email-Adresse")
    private String email;

    @NotBlank(message = "Passwort darf nicht leer sein")
    @Size(message = "Passwort muss zwischen 4 und  12 Zeichen lang sein")
    private String password;

    // Methoden

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
