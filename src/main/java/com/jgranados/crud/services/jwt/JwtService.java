/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.crud.services.jwt;

/**
 *
 * @author jose
 */
public interface JwtService {
    
    String generateToken(String username);
    
    String getUsername(String token);
    
    boolean isValid(String token);
}
