package de.artur.smartfacility.user.api;

import de.artur.smartfacility.user.dto.LoginRequest;
import de.artur.smartfacility.user.dto.RegisterRequest;
import de.artur.smartfacility.user.dto.UserResponse;
import de.artur.smartfacility.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody RegisterRequest dto){
       UserResponse response = userService.createUser(dto);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest dto){
        UserResponse response = userService.login(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
       userService.deleteUser(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
