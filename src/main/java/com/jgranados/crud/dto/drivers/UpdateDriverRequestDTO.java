/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.dto.drivers;

import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class UpdateDriverRequestDTO {
   private final String name;
   private final int age;
}
