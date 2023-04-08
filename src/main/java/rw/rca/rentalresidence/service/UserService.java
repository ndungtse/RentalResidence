package rw.rca.rentalresidence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rw.rca.rentalresidence.dto.AuthResponseDto;
import rw.rca.rentalresidence.dto.LoginDto;
import rw.rca.rentalresidence.dto.UserDTO;
import rw.rca.rentalresidence.dto.UserDTOMapper;
import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.repository.UserRepository;
import rw.rca.rentalresidence.security.JwtTokenProvider;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper,
            BCryptPasswordEncoder bCryptPasswordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public User userRegister(User registerDto) throws NotFoundException, Exception {
        User findUser = userRepository.findByEmail(registerDto.getEmail());
        if (findUser != null) {
            throw new Exception("User already exists");
        }
        registerDto.setPassword(bCryptPasswordEncoder.encode(registerDto.getPassword()));
        return userRepository.save(registerDto);
    }

    public AuthResponseDto userLogin(LoginDto loginDto) throws NotFoundException, Exception {
        String userEmail = loginDto.getEmail();
        String password = loginDto.getPassword();
        User findUser = userRepository.findByEmail(userEmail);
        if (findUser != null) {
            boolean passwordVerification = bCryptPasswordEncoder.matches(password, findUser.getPassword());
            if (passwordVerification) {
                System.out.println("Try to auth");
                Authentication authentication = authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
                System.out.println("after auth");
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = jwtTokenProvider.generateToken(authentication, findUser);
                return new AuthResponseDto("User Logged in successfully", jwt, findUser);
            } else {
                throw new Exception("Invalid Credential, Try again");
            }
        } else {
            throw new Exception("Invalid Credential, Try again");
        }
    }

    public List<UserDTO> findAll() {

        return userRepository.findAll()
                .stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public UserDTO findById(String id) {
        return userRepository.findById(id).map(userDTOMapper).orElse(null);
    }

    public UserDTO save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return userDTOMapper.apply(savedUser);
    }

    public UserDTO update(User user) {
        User updatedUser = userRepository.save(user);
        return userDTOMapper.apply(updatedUser);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    // update user role
    public UserDTO updateRole(String id, String role) {
        User user = userRepository.findById(id).orElse(null);
        List<String> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);
        User updatedUser = userRepository.save(user);
        return userDTOMapper.apply(updatedUser);
    }
}
