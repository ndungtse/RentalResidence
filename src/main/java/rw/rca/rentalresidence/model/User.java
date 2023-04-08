package rw.rca.rentalresidence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import rw.rca.rentalresidence.util.Role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private String phoneNumber;

    @DBRef
    private List<Booking> bookings;

    // user role default is user
    private List<String> roles = List.of(Role.USER);

    @DBRef
    private List<Property> properties;

    // getters and setters
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
