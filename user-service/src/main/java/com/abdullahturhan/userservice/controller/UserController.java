package com.abdullahturhan.userservice.controller;

import com.abdullahturhan.userservice.dto.UserDto;
import com.abdullahturhan.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping(path = "/register")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserDto userDto){
        userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
