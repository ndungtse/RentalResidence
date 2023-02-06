package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import rw.rca.rentalresidence.model.Property;

public interface PropertyRepository extends MongoRepository<Property, String> {
}

