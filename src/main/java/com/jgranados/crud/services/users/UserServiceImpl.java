/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.services.users;

import com.jgranados.crud.dto.users.NewUserRequestDTO;
import com.jgranados.crud.entities.users.User;
import com.jgranados.crud.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository,
            PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findById(username);
    }

    @Override
    public void createUser(NewUserRequestDTO newUser) {
        // TODO validation
        User user = new User();
        user.setUsername(newUser.getUsername());
        user.setRole(newUser.getRole());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        
        repository.save(user);
    }
}
