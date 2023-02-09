package rw.rca.rentalresidence.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import rw.rca.rentalresidence.dto.AuthResponseDto;
import rw.rca.rentalresidence.dto.LoginDto;
import rw.rca.rentalresidence.dto.UserDTO;
import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.service.UserService;
import rw.rca.rentalresidence.util.CustomResponse;

@RestController
@RequestMapping("/api/v1/auth")
@Api(tags = "Auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register")
    @ApiOperation(
            value = "User register",
            notes = "User registration in our application",
            response = AuthResponseDto.class
    )
    public ResponseEntity<CustomResponse<User>> authRegister(@RequestBody  User user){
        try {
            return ResponseEntity.created(null).body(new CustomResponse<>("User registered successfully", userService.userRegister(user), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("User not registered", null, false));
        }
    }

    @PostMapping(path = "/login")
    @ApiOperation(
            value = "User login",
            notes = "User login authentication in our application"
    )
    public ResponseEntity<CustomResponse<AuthResponseDto>> authLogin(@RequestBody LoginDto loginDto) {
        try {
            return ResponseEntity.created(null).body(new CustomResponse<>("User logged in successfully", userService.userLogin(loginDto), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("User not logged in", null, false));
        }   
    }

    @GetMapping
    @ApiResponse(code = 200, message = "Users found successfully", response = UserDTO.class)
    public ResponseEntity<CustomResponse<List<UserDTO>>> findAll() {
        try {
            return ResponseEntity.ok(new CustomResponse<>("Users found successfully", userService.findAll(), true));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>("Users not found", null, false));
        }
    }
    
}
