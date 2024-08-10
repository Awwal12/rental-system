package com.example.rental_system.repository;

import com.example.rental_system.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByLandlordId(Integer landlordId);
    List<Property> findByCity(String city);
    List<Property> findByPropertyType(String propertyType);
}