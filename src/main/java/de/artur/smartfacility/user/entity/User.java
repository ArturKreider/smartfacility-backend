package de.artur.smartfacility.user.entity;

import de.artur.smartfacility.building.entity.Building;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Building> buildings;

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

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return this.role;
    }

    public void setBuildings(List<Building> buildings){
        this.buildings = buildings;
    }
    public List<Building> getBuildings(){
        return this.buildings;
    }
}
