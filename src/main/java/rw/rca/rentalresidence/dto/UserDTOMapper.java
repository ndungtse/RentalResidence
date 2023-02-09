package rw.rca.rentalresidence.dto;

import org.springframework.stereotype.Service;
import rw.rca.rentalresidence.model.User;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getBookings(),
                user.getProperties()
        );
    }
}
