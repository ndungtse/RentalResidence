package rw.rca.rentalresidence.service;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import rw.rca.rentalresidence.model.Property;
import rw.rca.rentalresidence.repository.PropertyRepository;

import java.util.List;
import java.util.Map;

@Service
public class PropertyService {
    private final MongoTemplate mongoTemplate;
    private final PropertyRepository propertyRepository;

    public PropertyService(MongoTemplate mongoTemplate, PropertyRepository propertyRepository) {
        this.mongoTemplate = mongoTemplate;
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

    public List<Property> search(Map<String, String> criteria) {
        // Build the query to search properties based on the criteria
        Query query = new Query();
        for (Map.Entry<String, String> entry : criteria.entrySet()) {
            query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        // Execute the query and return the results
        return mongoTemplate.find(query, Property.class);
    }

    public List<Property> findByAddressCity(String city) {
        return propertyRepository.findByAddressCity(city);
    }

    public List<Property> findByAddress(String address_query) {
        Query query = new Query();
        // find where the address city, street, or country matches the query
        query.addCriteria(Criteria.where("address.city").regex(address_query, "i"));
        query.addCriteria(Criteria.where("address.street").regex(address_query, "i"));
        query.addCriteria(Criteria.where("address.country").regex(address_query, "i"));
        return mongoTemplate.find(query, Property.class);
    }

    public List<Property> findBySquareFootage(Integer squareFootage) {
        return propertyRepository.findBySquareFootage(squareFootage);
    }

    public List<Property> findByPrice(Double price) {
        return propertyRepository.findByPrice(price);
    }

    public List<Property> findByNumberOfBathrooms(Integer numberOfBathrooms) {
        return propertyRepository.findByNumberOfBathrooms(numberOfBathrooms);
    }

    public List<Property> findByNumberOfBedrooms(Integer numberOfBedrooms) {
        return propertyRepository.findByNumberOfBedrooms(numberOfBedrooms);
    }

    public List<Property> findByUser(String id) {
        return propertyRepository.findByUser(id);
    }

}
