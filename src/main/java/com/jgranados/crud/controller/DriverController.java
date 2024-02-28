/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.controller;

import com.jgranados.crud.dto.drivers.DriverResponseDTO;
import com.jgranados.crud.dto.drivers.NewDriverRequestDTO;
import com.jgranados.crud.dto.drivers.UpdateDriverRequestDTO;
import com.jgranados.crud.exceptions.NotFoundException;
import com.jgranados.crud.exceptions.ServiceException;
import com.jgranados.crud.services.driver.DriverService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose REST Representational State transfer HTTP POST -> create PUT ->
 * update DELETE -> remove GET -> get PATCH -> partial update
 */
@RestController
@RequestMapping("/v1/drivers")
public class DriverController {

    private DriverService driverService;

    @Autowired
    public DriverController(DriverService DriverService) {
        this.driverService = DriverService;
    }

    @PostMapping
    public ResponseEntity<DriverResponseDTO> createDriver(@RequestBody NewDriverRequestDTO newDriver) {
        DriverResponseDTO responseDTO = driverService.createDriver(newDriver);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<DriverResponseDTO>> findAllDrivers() {
        return ResponseEntity.ok(driverService.findAll());
    }

    // /v1/drivers/3
    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> deleteDrvier(@PathVariable Long driverId)
            throws ServiceException {
        driverService.deleteDriver(driverId);
        return ResponseEntity.accepted().build();
    }

    // /v1/drivers/3
    @PutMapping("/{driverId}")
    public ResponseEntity<DriverResponseDTO> updateDriver(@PathVariable Long driverId,
            @RequestBody UpdateDriverRequestDTO dataToUpdate) throws ServiceException {
        DriverResponseDTO responseDTO = driverService.updateDriver(driverId, dataToUpdate);

        return ResponseEntity.ok(responseDTO);
    }
}
