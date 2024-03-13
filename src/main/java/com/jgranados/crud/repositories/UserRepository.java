/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.crud.repositories;

import com.jgranados.crud.entities.drivers.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jose
 */
public interface UserRepository extends CrudRepository<User, String> {
    
}
