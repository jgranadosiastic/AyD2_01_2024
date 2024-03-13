/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.crud.services.users;

import com.jgranados.crud.entities.drivers.User;
import java.util.Optional;

/**
 *
 * @author jose
 */
public interface UserService {
    
    Optional<User> findByUsername(String username);
}
