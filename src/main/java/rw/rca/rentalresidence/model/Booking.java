package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Document(collection = "bookings")
public class Booking {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private Date startDate;
    private Date endDate;
    private Double totalPrice;

    @DBRef
    private User user;

    @DBRef
    private Property property;

}

