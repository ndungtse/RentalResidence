package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.model.Transaction;
import rw.rca.rentalresidence.service.TransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transactions")
@Api(tags = "Transactions")
public class TransactionController {
   private final TransactionService transactionService;

   @Autowired
   public TransactionController(TransactionService transactionService) {
      this.transactionService = transactionService;
   }

   @PostMapping
   @ApiOperation(value = "Create a transaction")
   public Transaction createTransaction(@RequestBody Transaction transaction) {
      return transactionService.createTransaction(transaction);
   }

   @GetMapping
   @ApiOperation(value = "View a list of available transactions", response = List.class)
   public List<Transaction> getAllTransactions() {
      return transactionService.getAllTransactions();
   }

   @GetMapping("/{id}")
   @ApiOperation(value = "Get a transaction by Id")
   public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") String id) {
      Optional<Transaction> transaction = transactionService.getTransactionById(id);
      return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
   @ApiOperation(value = "Delete a transaction")
   public void deleteTransaction(@PathVariable("id") String id) {
      transactionService.deleteTransaction(id);
   }
}
