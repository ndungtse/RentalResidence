package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Document(collection = "properties")
public class Property {
    @Id
    private String id;

    private Address address;
    private Double price;
    private Integer numberOfBedrooms;
    private Integer numberOfBathrooms;
    private Integer squareFootage;
    private boolean hasParking;
    private boolean isPetAllowed;
    private String type;

    @DBRef
    private User user;

    @DBRef
    private List<Image> images;

    @DBRef
    private List<Amenity> amenities;

    @DBRef
    private List<Booking> bookings;

    @DBRef
    private List<Review> reviews;
}
