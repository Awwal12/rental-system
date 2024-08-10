package com.example.rental_system.service;

import com.example.rental_system.entity.Property;
import com.example.rental_system.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Optional<Property> getPropertyById(Long id) {
        return propertyRepository.findById(id);
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Optional<Property> updateProperty(Long id, Property propertyDetails) {
        Optional<Property> property = propertyRepository.findById(id);
        if (property.isPresent()) {
            Property updatedProperty = property.get();
            updatedProperty.setTitle(propertyDetails.getTitle());
            updatedProperty.setDescription(propertyDetails.getDescription());
            updatedProperty.setAddress(propertyDetails.getAddress());
            updatedProperty.setCity(propertyDetails.getCity());
            updatedProperty.setState(propertyDetails.getState());
            updatedProperty.setZipCode(propertyDetails.getZipCode());
            updatedProperty.setCountry(propertyDetails.getCountry());
            updatedProperty.setPricePerNight(propertyDetails.getPricePerNight());
            updatedProperty.setPropertyType(propertyDetails.getPropertyType());
            return Optional.of(propertyRepository.save(updatedProperty));
        }
        return Optional.empty();
    }

    public boolean deleteProperty(Long id) {
        Optional<Property> property = propertyRepository.findById(id);
        if (property.isPresent()) {
            propertyRepository.delete(property.get());
            return true;
        }
        return false;
    }

    public List<Property> getPropertiesByLandlord(Integer landlordId) {
        return propertyRepository.findByLandlordId(landlordId);
    }

    public List<Property> getPropertiesByCity(String city) {
        return propertyRepository.findByCity(city);
    }

    public List<Property> getPropertiesByType(String propertyType) {
        return propertyRepository.findByPropertyType(propertyType);
    }
}