/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.crud.services.driver;

import com.jgranados.crud.dto.drivers.DriverResponseDTO;
import com.jgranados.crud.dto.drivers.NewDriverRequestDTO;
import com.jgranados.crud.dto.drivers.UpdateDriverRequestDTO;
import com.jgranados.crud.entities.drivers.Driver;
import com.jgranados.crud.exceptions.NotFoundException;
import com.jgranados.crud.exceptions.ServiceException;
import java.util.List;

/**
 *
 * @author jose
 */
public interface DriverService {

    DriverResponseDTO createDriver(NewDriverRequestDTO newDriver);

    List<DriverResponseDTO> findAll();

    void deleteDriver(Long id) throws ServiceException;

    DriverResponseDTO updateDriver(Long id, UpdateDriverRequestDTO dataToUpdate)
            throws ServiceException;
}
