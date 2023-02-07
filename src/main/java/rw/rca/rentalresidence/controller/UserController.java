package rw.rca.rentalresidence.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.rca.rentalresidence.model.User;
import rw.rca.rentalresidence.service.UserService;
import rw.rca.rentalresidence.util.CustomResponse;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public CustomResponse<List<User>> findAll() {
        try {
            return new CustomResponse<>("Users found successfully", userService.findAll(), true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("Users not found", null, false);
        }
    }

    @GetMapping("/{id}")
    public CustomResponse<User> findById(@PathVariable String id) {
        try {
            return new CustomResponse<>("User found successfully", userService.findById(id), true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("User not found", null, false);
        }
    }

    @PostMapping
    public CustomResponse<User> save(@RequestBody User user) {
        try {
            return new CustomResponse<>("User saved successfully", userService.save(user), true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("User not saved", null, false);
        }
    }

    @DeleteMapping("/{id}")
    public CustomResponse<User> deleteById(@PathVariable String id) {
        try {
            userService.deleteById(id);
            return new CustomResponse<>("User deleted successfully", null, true);
        } catch (Exception e) {
            e.printStackTrace();
            return new CustomResponse<>("User not deleted", null, false);
        }
    }
}

