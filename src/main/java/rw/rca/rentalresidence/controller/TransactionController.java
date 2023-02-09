package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.model.Transaction;
import rw.rca.rentalresidence.service.TransactionService;
import rw.rca.rentalresidence.util.CustomResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transactions")
@Api(tags = "Transactions")
public class TransactionController {
   private final TransactionService transactionService;

   public TransactionController(TransactionService transactionService) {
      this.transactionService = transactionService;
   }

   @PostMapping
   @ApiOperation(value = "Create a transaction")
   public ResponseEntity<CustomResponse<Transaction>> createTransaction(@RequestBody Transaction transaction) {
      try {
         return ResponseEntity.created(null).body(new CustomResponse<>("Transaction created successfully", transactionService.createTransaction(transaction), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Transaction not created", null, false));
      }
   }

   @GetMapping
   @ApiOperation(value = "View a list of available transactions", response = List.class)
   public ResponseEntity<CustomResponse<List<Transaction>>> getAllTransactions() {
      try {
         return ResponseEntity.ok(new CustomResponse<>("Transactions found successfully", transactionService.getAllTransactions(), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Transactions not found", null, false));
      }
   }

   @GetMapping("/{id}")
   @ApiOperation(value = "Get a transaction by Id")
   public ResponseEntity<CustomResponse<Optional<Transaction>>> getTransactionById(@PathVariable("id") String id) {
      try {
         return ResponseEntity.ok(new CustomResponse<>("Transaction found successfully", transactionService.getTransactionById(id), true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Transaction not found", null, false));
      }
   }

   @DeleteMapping("/{id}")
   @ApiOperation(value = "Delete a transaction")
   public ResponseEntity<CustomResponse<?>> deleteTransaction(@PathVariable("id") String id) {
      try {
         transactionService.deleteTransaction(id);
         return ResponseEntity.accepted().body(new CustomResponse<>("Transaction deleted successfully", null, true));
      } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.badRequest().body(new CustomResponse<>("Transaction not deleted", null, false));
      }
   }
}
