/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.dto.users;

import com.jgranados.crud.enums.users.Role;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class NewUserRequestDTO {
    private final String username;
    private final Role role;
    private final String password;
    
}
