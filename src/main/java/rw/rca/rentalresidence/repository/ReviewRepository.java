package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import rw.rca.rentalresidence.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {
}

