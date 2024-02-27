/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.services.driver;

import com.jgranados.crud.dto.drivers.DriverResponseDTO;
import com.jgranados.crud.dto.drivers.NewDriverRequestDTO;
import com.jgranados.crud.entities.drivers.Driver;
import com.jgranados.crud.exceptions.NotFoundException;
import com.jgranados.crud.repositories.DriverRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author jose
 */
@Service
@Slf4j
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
    
    @Override
    public void deleteDriver(Long id) throws NotFoundException {
        Optional<Driver> driverToDelete = driverRepository.findById(id);
        if (driverToDelete.isEmpty()) {
            throw new NotFoundException(String.format("Driver with Id: %s not found", id));
        }
        driverRepository.deleteById(id);
    }
    
}
