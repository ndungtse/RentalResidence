package rw.rca.rentalresidence.util;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import rw.rca.rentalresidence.model.User;

public class Mapper {

    public static ModelMapper modelMapper = new ModelMapper();
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static User getUserFromDTO(Object object, String password) {
        User user = getUserFromDTO(object);
        user.setPassword(passwordEncoder.encode(password));
        user.setId(null);
        return user;
    }

    public static String encode(String raw) {
        return passwordEncoder.encode(raw);
    }

    public static boolean compare(String encoded, String raw) {
        return passwordEncoder.matches(raw, encoded);
    }

    public static User getUserFromDTO(Object object) {
        return modelMapper.map(object, User.class);
    }

}
