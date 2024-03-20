/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.crud.repositories;

import com.jgranados.crud.entities.users.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jose
 */
public interface UserRepository extends CrudRepository<User, String> {
    
    List<User> findAll();
}
