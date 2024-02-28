/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.exceptions;

/**
 *
 * @author jose
 */
public class DuplicatedEntityException extends ServiceException {

    public DuplicatedEntityException() {
    }

    public DuplicatedEntityException(String message) {
        super(message);
    }
    
}
