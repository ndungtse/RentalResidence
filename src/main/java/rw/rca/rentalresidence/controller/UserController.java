package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.dto.UserDTO;
import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.service.UserService;
import rw.rca.rentalresidence.util.CustomResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Api(tags = "Users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ApiResponse(code = 200, message = "Users found successfully", response = UserDTO.class)
    public CustomResponse<List<UserDTO>> findAll() {
        try {
            return new CustomResponse<>("Users found successfully", userService.findAll(), true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("Users not found", null, false);
        }
    }

    @GetMapping("/{id}")
    @ApiResponse(code = 200, message = "User found successfully", response = UserDTO.class)
    public CustomResponse<UserDTO> findById(@PathVariable String id) {
        try {
            return new CustomResponse<>("User found successfully", userService.findById(id), true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("User not found", null, false);
        }
    }

    @PostMapping
    @ApiResponse(code = 200, message = "User saved successfully", response = UserDTO.class)
    public CustomResponse<UserDTO> save(@RequestBody User user) {
        try {
            return new CustomResponse<>("User saved successfully", userService.save(user), true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("User not saved", null, false);
        }
    }

    @DeleteMapping("/{id}")
    @ApiResponse(code = 200, message = "User deleted successfully")
    public CustomResponse<UserDTO> deleteById(@PathVariable String id) {
        try {
            userService.deleteById(id);
            return new CustomResponse<>("User deleted successfully", null, true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("User not deleted", null, false);
        }
    }
}

