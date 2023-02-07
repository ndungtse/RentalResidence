package rw.rca.rentalresidence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import rw.rca.rentalresidence.dto.UserDTO;
import rw.rca.rentalresidence.dto.UserDTOMapper;
import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
}

