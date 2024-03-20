/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.dto.users;

import com.jgranados.crud.entities.users.User;
import com.jgranados.crud.enums.users.Role;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class UserResponseDTO {
    private String username;
    private Role role;
    
    public UserResponseDTO(User userEntity) {
        username = userEntity.getUsername();
        role = userEntity.getRole();
    }
}
