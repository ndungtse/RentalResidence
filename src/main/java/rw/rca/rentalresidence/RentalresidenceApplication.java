package rw.rca.rentalresidence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class RentalresidenceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalresidenceApplication.class, args);
    }
}
