/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.services.driver;

import com.jgranados.crud.dto.drivers.DriverResponseDTO;
import com.jgranados.crud.dto.drivers.UpdateDriverRequestDTO;
import com.jgranados.crud.entities.drivers.Driver;
import com.jgranados.crud.exceptions.NotFoundException;
import com.jgranados.crud.repositories.DriverRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author jose
 */
@ExtendWith(MockitoExtension.class)
public class DriverServiceImplTest {

    private static final Long DRIVER_ID = 1L;
    private static final String DRIVER_NAME = "driver name";
    private static final int DRIVER_AGE = 21;

    @Mock
    DriverRepository driverRepository;
    @InjectMocks
    DriverServiceImpl serviceToTest;

    @Test
    void testUpdateDriverWhenDriverToUpdateExistsAndNameIsNotDuplicated() throws Exception {
        // Arrange
        Driver driver = new Driver();
        driver.setId(DRIVER_ID);
        UpdateDriverRequestDTO dataToUpdate = new UpdateDriverRequestDTO(DRIVER_NAME, DRIVER_AGE);

        when(driverRepository.findById(DRIVER_ID))
                .thenReturn(Optional.of(driver));
        when(driverRepository.findFirstByNameAndNotId(DRIVER_ID, DRIVER_NAME))
                .thenReturn(Optional.empty());

        // Act
        DriverResponseDTO result = serviceToTest.updateDriver(DRIVER_ID, dataToUpdate);

        // Assert
        assertAll(
                () -> assertEquals(DRIVER_ID, result.getId()),
                () -> assertEquals(DRIVER_NAME, result.getName()),
                () -> assertEquals(DRIVER_AGE, result.getAge())
        );
        verify(driverRepository).save(driver);
    }

    @Test
    void testUpdateDriverWhenDriverToUpdateDoesNotExist() {
        // Arrange
        UpdateDriverRequestDTO dataToUpdate = new UpdateDriverRequestDTO(DRIVER_NAME, DRIVER_AGE);
        when(driverRepository.findById(DRIVER_ID))
                .thenReturn(Optional.empty());

        // Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> serviceToTest.updateDriver(DRIVER_ID, dataToUpdate)
        );

    }
}
