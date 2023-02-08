package rw.rca.rentalresidence.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.rca.rentalresidence.util.CustomResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public CustomResponse<?> handleError(HttpServletRequest request) {
        Object error = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (error instanceof Exception) {
            return new CustomResponse<>("Something went wrong.", ((Exception) error).getMessage());
        }
        System.out.println("error "+request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        System.out.println("error "+request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        return new CustomResponse<>("Something went wrong.", "Error Message: " + request.getAttribute(RequestDispatcher.ERROR_MESSAGE ));
    }


    public String getErrorPath() {
        return "/error";
    }
}
