package rw.rca.rentalresidence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import rw.rca.rentalresidence.model.Property;
import rw.rca.rentalresidence.repository.PropertyRepository;

@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public Property findById(String id) {
        return propertyRepository.findById(id).orElse(null);
    }

    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public void deleteById(String id) {
        propertyRepository.deleteById(id);
    }

    public Property update(String id, Property property) {
        Property propertyToUpdate = findById(id);
        propertyToUpdate.setAddress(property.getAddress());
        propertyToUpdate.setAmenities(property.getAmenities());
        propertyToUpdate.setBookings(property.getBookings());
        propertyToUpdate.setImages(property.getImages());
        propertyToUpdate.setUser(property.getUser());
        propertyToUpdate.setPrice(property.getPrice());
        propertyToUpdate.setNumberOfBedrooms(property.getNumberOfBedrooms());
        return propertyRepository.save(propertyToUpdate);

    }
}
