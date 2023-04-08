package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rca.rentalresidence.util.CustomResponse;

@RestController
@RequestMapping("/")
@Api(tags = "Home")
public class HomeController {

    @GetMapping("")
    public CustomResponse<String> welcomeApi() {
        return new CustomResponse<>("Welcome to Rental Residence API", "Welcome to Rental Residence API", true);
    }
    @GetMapping("api/v1")
    public CustomResponse<String> welcomeV1Api() {
        return new CustomResponse<>("Welcome to Rental Residence v1 API", "Welcome to Rental Residence API", true);
    }
}