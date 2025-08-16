package com.crownstonebank.controller;

import com.crownstonebank.dto.UserDTO;
import com.crownstonebank.entity.User;
import com.crownstonebank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) {
        User registeredUser = userService.registerUser(userDTO);
        return ResponseEntity.ok(registeredUser);
    }

    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userDTO) {
        var authObject = userService.authenticateUser(userDTO);
    }
}
