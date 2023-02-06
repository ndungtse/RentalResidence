package rw.rca.rentalresidence.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;

    private Date startDate;
    private Date endDate;
    private Double totalPrice;

    @DBRef
    private User user;

    @DBRef
    private Property property;

    // getters and setters

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public Property getProperty() {
        return property;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}

