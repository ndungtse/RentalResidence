package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.model.Booking;
import rw.rca.rentalresidence.service.BookingService;
import rw.rca.rentalresidence.util.CustomResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
@Api(tags = "Bookings")
public class BookingController {
   private final BookingService bookingService;

   public BookingController(BookingService bookingService) {
      this.bookingService = bookingService;
   }

   @PostMapping
   @ApiOperation(value = "Create a booking")
   public CustomResponse<Booking> createBooking(@RequestBody Booking booking) {
      try {
         return new CustomResponse<>("Booking created successfully", bookingService.createBooking(booking), true);
      } catch (Exception e) {
         return new CustomResponse<>("Booking creation failed", null, false);
      }
   }

   @GetMapping
   @ApiOperation(value = "View a list of available bookings", response = List.class)
   public CustomResponse<List<Booking>> getAllBookings() {
      try {
         return new CustomResponse<>("Bookings retrieved successfully", bookingService.getAllBookings(), true);
      } catch (Exception e) {
         return new CustomResponse<>("Bookings retrieval failed", null, false);
      }
   }

    @GetMapping("/pageable")
    @ApiOperation(value = "View a list of available bookings", response = List.class)
    public CustomResponse<Page<Booking>> getAllBookings(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "limit", defaultValue = "10") int limit) {
        try {
           Pageable pageable = PageRequest.of(page, limit, Sort.Direction.ASC, "id");
//            return new CustomResponse<>("Bookings retrieved successfully", bookingService.getAllBookings(pageable), true);
            return new CustomResponse<>("Bookings retrieved successfully", bookingService.getAllBookings(pageable), true);
        } catch (Exception e) {
            return new CustomResponse<>("Bookings retrieval failed", null, false);
        }
    }

   @GetMapping("/{id}")
   @ApiOperation(value = "Get a booking by Id")
   public CustomResponse<Booking> getBookingById(@PathVariable("id") String id) {
      try {
         Optional<Booking> booking = bookingService.getBookingById(id);
         return new CustomResponse<>("Booking retrieved successfully", booking.get(), true);
      } catch (Exception e) {
         return new CustomResponse<>("Booking retrieval failed", null, false);
      }
   }

   @DeleteMapping("/{id}")
   @ApiOperation(value = "Delete a booking")
   public CustomResponse<?> deleteBooking(@PathVariable("id") String id) {
      try {
         bookingService.deleteBooking(id);
         return new CustomResponse<>("Booking deleted successfully", null, true);
      } catch (Exception e) {
         return new CustomResponse<>("Booking deletion failed", null, false);
      }
   }
}

