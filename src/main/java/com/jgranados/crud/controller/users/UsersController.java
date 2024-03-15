/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.controller.users;

import com.jgranados.crud.dto.drivers.DriverResponseDTO;
import com.jgranados.crud.dto.drivers.NewDriverRequestDTO;
import com.jgranados.crud.dto.users.NewUserRequestDTO;
import com.jgranados.crud.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
@RequestMapping("/v1/users")
public class UsersController {
    
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody NewUserRequestDTO newUser) {
        userService.createUser(newUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
