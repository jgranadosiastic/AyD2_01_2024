/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.dto.drivers;

import com.jgranados.crud.entities.drivers.Driver;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class DriverResponseDTO {
    Long id;
    String name;
    int age;
    
    public DriverResponseDTO(Driver driverEntity) {
        this.id = driverEntity.getId();
        this.name = driverEntity.getName();
        this.age = driverEntity.getAge();
    }
}
