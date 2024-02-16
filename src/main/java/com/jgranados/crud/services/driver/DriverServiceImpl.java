/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.services.driver;

import com.jgranados.crud.dto.drivers.DriverResponseDTO;
import com.jgranados.crud.dto.drivers.NewDriverRequestDTO;
import com.jgranados.crud.entities.drivers.Driver;
import com.jgranados.crud.repositories.DriverRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose
 */
@Service
public class DriverServiceImpl implements DriverService {
    
    private DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverResponseDTO createDriver(NewDriverRequestDTO newDriver) {
        Driver newDriverEntity = new Driver();
        newDriverEntity.setAge(newDriver.getAge());
        newDriverEntity.setName(newDriver.getName());
        
        newDriverEntity = driverRepository.save(newDriverEntity);
        
        return new DriverResponseDTO(newDriverEntity);
    }

    @Override
    public List<DriverResponseDTO> findAll() {
        return driverRepository.findAll()
                .stream()
                //.map(driver -> new DriverResponseDTO(driver))
                .map(DriverResponseDTO::new)
                .collect(Collectors.toList());
    }
    
    
    
}
