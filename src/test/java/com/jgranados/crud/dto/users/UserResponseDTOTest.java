/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.dto.users;

import com.jgranados.crud.entities.users.User;
import com.jgranados.crud.enums.users.Role;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose
 */
public class UserResponseDTOTest {
    
    private static final String USERNAME = "username";
    
    @Test
    void testConstructorUsingUserEntity() {
        // Arrange
        User user = new User();
        user.setUsername(USERNAME);
        user.setRole(Role.DRIVER);
        
        // Act
        UserResponseDTO result =  new UserResponseDTO(user);
        
        // Assert
        /*Assertions.assertEquals(USERNAME, result.getUsername());
        Assertions.assertEquals(Role.DRIVER, result.getRole());*/
        assertAll(
                () -> assertEquals(USERNAME, result.getUsername()),
                () -> assertEquals(Role.DRIVER, result.getRole())
        );
    }
    
}
