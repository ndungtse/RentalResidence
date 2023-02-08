package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rw.rca.rentalresidence.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String username);
}

