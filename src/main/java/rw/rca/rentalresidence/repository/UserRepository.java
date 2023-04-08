package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rw.rca.rentalresidence.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String username);

    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);
}

