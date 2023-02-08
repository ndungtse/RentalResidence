package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rw.rca.rentalresidence.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
