package rw.rca.rentalresidence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rw.rca.rentalresidence.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}

