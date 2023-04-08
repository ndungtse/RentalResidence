package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.dto.AuthResponseDto;
import rw.rca.rentalresidence.dto.LoginDto;
import rw.rca.rentalresidence.dto.UserDTO;
import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.service.UserService;
import rw.rca.rentalresidence.util.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@Api(tags = "Auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    @ApiOperation(value = "User register", notes = "User registration in our application", response = AuthResponseDto.class)
    public ResponseEntity<CustomResponse<User>> authRegister(@RequestBody User user) {
        try {
            return ResponseEntity.created(null)
                    .body(new CustomResponse<>("User registered successfully", userService.userRegister(user), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("User not registered", null, false));
        }
    }

    @PostMapping(path = "/login")
    @ApiOperation(value = "User login", notes = "User login authentication in our application")
    public ResponseEntity<CustomResponse<AuthResponseDto>> authLogin(@RequestBody LoginDto loginDto) {
        System.out.println("loginDto" + loginDto);
        try {
            AuthResponseDto res = userService.userLogin(loginDto);
            return ResponseEntity.accepted()
                    .body(new CustomResponse<>("User logged in successfully", res,
                            true));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(new CustomResponse<>("User not loggedin", null, false));
        }
    }
}
