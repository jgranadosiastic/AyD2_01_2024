/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.controller.users;

import com.jgranados.crud.controller.drivers.AbstractMvcTest;
import com.jgranados.crud.dto.users.UserResponseDTO;
import com.jgranados.crud.entities.users.User;
import com.jgranados.crud.enums.users.Role;
import com.jgranados.crud.services.users.UserService;
import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author jose
 */
@ContextConfiguration(classes = {UsersController.class, UserService.class})
public class UsersControllerTest extends AbstractMvcTest {

    private static final String USERNAME = "name";

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser("ADMIN")
    void testGetAllUSers() throws Exception {
        // Arrange
        User userEntity = new User();
        userEntity.setUsername(USERNAME);
        userEntity.setRole(Role.ADMIN);
        UserResponseDTO userDto = new UserResponseDTO(userEntity);

        when(userService.findAllUsers()).thenReturn(Collections.singletonList(userDto));

        // Act
        mockMvc.perform(get("/v1/users"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(Collections.singletonList(userDto))));
    }
}
