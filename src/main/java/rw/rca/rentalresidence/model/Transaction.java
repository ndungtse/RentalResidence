package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    private Double amount;
    private Date date;

    @DBRef
    private User user;

    @DBRef
    private Property property;
}

