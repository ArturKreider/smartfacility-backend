package de.artur.smartfacility.user.service;

import de.artur.smartfacility.user.dto.LoginRequest;
import de.artur.smartfacility.user.dto.RegisterRequest;
import de.artur.smartfacility.user.dto.UserResponse;
import de.artur.smartfacility.user.entity.Role;
import de.artur.smartfacility.user.entity.User;
import de.artur.smartfacility.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UserResponse> createUser (RegisterRequest dto){
        boolean existByEmail = userRepository.existsByEmail(dto.getEmail());
        if (existByEmail){
            return Optional.empty();
        }
        User newUser = mapToEntity(dto);
        newUser.setRole(Role.USER);
        String hashedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(hashedPassword);
        User registeredUser = userRepository.save(newUser);
        UserResponse response = mapToResponse(registeredUser);
        return Optional.of(response);
    }

    public Optional<UserResponse> login (LoginRequest login){
        Optional<User> optionalUser = userRepository.findByEmail(login.getEmail());
        if(optionalUser.isEmpty()){
            return Optional.empty();
        }
        User existingUser = optionalUser.get();
        boolean passwordCorrect = passwordEncoder.matches(login.getPassword(), existingUser.getPassword());
        if(!passwordCorrect){
            return Optional.empty();
        }
        UserResponse response = mapToResponse(existingUser);
        return Optional.of(response);
    }

    // Mapping

    private User mapToEntity(RegisterRequest dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    private UserResponse mapToResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        return response;
    }
}
