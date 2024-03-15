/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.entities.users;

import com.jgranados.crud.enums.users.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column
    private String username;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    private String password;
}
