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
        return userService.createUser(dto)
                .map(user -> ResponseEntity.status(HttpStatus.CREATED).body(user))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest dto){
        return userService.login(dto)
                .map(user -> ResponseEntity.status(HttpStatus.OK).body(user))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}
