package rw.rca.rentalresidence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import rw.rca.rentalresidence.util.Role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
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
}
