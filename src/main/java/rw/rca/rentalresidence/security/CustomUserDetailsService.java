package rw.rca.rentalresidence.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import rw.rca.rentalresidence.exceptions.BadRequestException;
import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.repository.UserRepository;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @Transactional
    public UserDetails loadByUserId(String id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        log.info("User found with id: " + user.getId());
        return UserPrincipal.create(user);
    }

    // @Transactional
    public UserDetails loadUserByUsername(String s) throws BadRequestException {
        User user = userRepository.findByEmailOrPhoneNumber(s, s)
                .orElseThrow(() -> new UsernameNotFoundException("user not found with email or mobile of " + s));
        return UserPrincipal.create(user);
    }
}
