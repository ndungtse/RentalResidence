package rw.rca.rentalresidence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.rca.rentalresidence.model.Transaction;
import rw.rca.rentalresidence.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
   private final TransactionRepository transactionRepository;

   @Autowired
   public TransactionService(TransactionRepository transactionRepository) {
      this.transactionRepository = transactionRepository;
   }

   public Transaction createTransaction(Transaction transaction) {
      return transactionRepository.save(transaction);
   }

   public List<Transaction> getAllTransactions() {
      return transactionRepository.findAll();
   }

   public Optional<Transaction> getTransactionById(String id) {
      return transactionRepository.findById(id);
   }

   public void deleteTransaction(String id) {
      transactionRepository.deleteById(id);
   }
}

