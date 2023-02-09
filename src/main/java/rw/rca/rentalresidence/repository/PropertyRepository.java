package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rw.rca.rentalresidence.model.Address;
import rw.rca.rentalresidence.model.Property;

import java.util.List;

public interface PropertyRepository extends MongoRepository<Property, String> {
    List<Property> findByAddressCity(String city);
    List<Property> findByAddress(Address address);
    List<Property> findByUser(String id);
    List<Property> findBySquareFootage(Integer squareFootage);
    List<Property> findByPrice(Double price);
    List<Property> findByNumberOfBathrooms(Integer numberOfBathrooms);
    List<Property> findByNumberOfBedrooms(Integer numberOfBedrooms);
}

