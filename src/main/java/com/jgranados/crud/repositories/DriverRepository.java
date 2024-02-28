/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.crud.repositories;

import com.jgranados.crud.entities.drivers.Driver;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jose
 */
@Repository
public interface DriverRepository extends CrudRepository<Driver, Long>{
    
    @Override
    List<Driver> findAll();
    
    @Query("select d from Driver d where name = :name and id <> :id")
    Optional<Driver> findFirstByNameAndNotId(Long id, String name);
    
    @Query(value = "select * from driver d where d.name = :name and d.id <> :id", nativeQuery = true)
    Optional<Driver> findFirstByNameAndNotIdNative(Long id, String name);
    
    
    @Query("select d from Driver d where d.name = :name and d.id <> :id")
    List<Driver> findDuplicatedByNameAndId(@Param("id") Long id, @Param("name") String name);
}
