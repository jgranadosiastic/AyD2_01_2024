/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.security;

import com.jgranados.crud.entities.users.User;
import com.jgranados.crud.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findById(username);
        if (userOpt.isPresent()) {
            
            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(userOpt.get().getUsername())
                    .password(userOpt.get().getPassword())
                    .roles(userOpt.get().getRole().toString())
                    .build();
            
            return userDetails;
        }
        
        throw new UsernameNotFoundException("User not foud.");
    }
    
}
