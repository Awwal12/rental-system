package com.example.rental_system.controller;

import com.example.rental_system.entity.Property;
import com.example.rental_system.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        List<Property> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        Optional<Property> property = propertyService.getPropertyById(id);
        return property.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        Property savedProperty = propertyService.addProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProperty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody Property propertyDetails) {
        Optional<Property> updatedProperty = propertyService.updateProperty(id, propertyDetails);
        return updatedProperty.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        boolean deleted = propertyService.deleteProperty(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/landlord/{landlordId}")
    public ResponseEntity<List<Property>> getPropertiesByLandlord(@PathVariable Integer landlordId) {
        List<Property> properties = propertyService.getPropertiesByLandlord(landlordId);
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<Property>> getPropertiesByCity(@PathVariable String city) {
        List<Property> properties = propertyService.getPropertiesByCity(city);
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/type/{propertyType}")
    public ResponseEntity<List<Property>> getPropertiesByType(@PathVariable String propertyType) {
        List<Property> properties = propertyService.getPropertiesByType(propertyType);
        return ResponseEntity.ok(properties);
    }
}