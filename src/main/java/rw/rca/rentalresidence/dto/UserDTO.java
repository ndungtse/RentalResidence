package rw.rca.rentalresidence.dto;

import rw.rca.rentalresidence.model.Booking;
import rw.rca.rentalresidence.model.Property;

import java.util.List;

public record UserDTO(
        String id,
        String name,
        String email,
        String phoneNumber,
        List<Booking> bookings,
        List<Property> properties
) {
}
