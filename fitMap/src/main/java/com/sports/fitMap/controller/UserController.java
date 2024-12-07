package com.sports.fitMap.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.sports.fitMap.model.UserDTO;
import com.sports.fitMap.model.UserEntity;
import com.sports.fitMap.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            if (userDTO == null || userDTO.getPassword() == null) {
                throw new RuntimeException("Invalid Password value.");
            }

            UserEntity user = UserEntity.builder()
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .email(userDTO.getEmail())
                    .address(userDTO.getAddress())
                    .remarks(userDTO.getRemarks())
                    .build();

            UserEntity registeredUser = userService.create(user);

            UserDTO responseUserDTO = UserDTO.builder()
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .email(registeredUser.getEmail())
                    .address(registeredUser.getAddress())
                    .remarks(registeredUser.getRemarks())
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User creation failed");
        }
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
    
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = userService.getByCredentials(userDTO.getEmail(), userDTO.getPassword());

            if (user != null) {
                final UserDTO responseUserDTO = UserDTO.builder()
                    .username(user.getUsername())
                    .id(user.getId())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .remarks(user.getRemarks())
                    .build();
                return ResponseEntity.ok().body(responseUserDTO);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid email or password");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An error occurred while processing the request");
        }
    }
}

