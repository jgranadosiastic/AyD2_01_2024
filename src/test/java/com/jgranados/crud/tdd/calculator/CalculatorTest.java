/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.tdd.calculator;

import org.apache.commons.lang3.StringUtils;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jose
 */
public class CalculatorTest {
    
    private static final int NUMBER_A = 5;
    private static final int NUMBER_B = 2;
    private static final int EXPECTED_SUM = 7;
    private static final int EXPECTED_SUBS = 3;
    
    @Test
    void testSumOfTwoNumbers() {
        // Arrange
        Calculator calculator = new Calculator();
        
        // Act
        int result = calculator.sum(NUMBER_A, NUMBER_B);
        
        // Assert
        assertEquals(EXPECTED_SUM, result);
    }
    
    @Test
    void testSubstractTwoNumbers() {
        // Arrange
        Calculator calculator = new Calculator();
        
        // Act
        int result = calculator.subs(NUMBER_A, NUMBER_B);
        
        // Assert
        assertEquals(EXPECTED_SUBS, result);
    }
}
