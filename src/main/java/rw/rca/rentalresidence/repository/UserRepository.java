package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import rw.rca.rentalresidence.model.User;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{ 'email' : ?0 }")
    User findByEmail(String email);

    @Query("{ 'names' : ?0 }")
    User findByNames(String username);

    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);
}

