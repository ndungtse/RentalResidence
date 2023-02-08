package rw.rca.rentalresidence.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.rca.rentalresidence.model.Booking;
import rw.rca.rentalresidence.service.BookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bookings")
@Api(tags = "Bookings")
public class BookingController {
   private final BookingService bookingService;

   @Autowired
   public BookingController(BookingService bookingService) {
      this.bookingService = bookingService;
   }

   @PostMapping
   @ApiOperation(value = "Create a booking")
   public Booking createBooking(@RequestBody Booking booking) {
      return bookingService.createBooking(booking);
   }

   @GetMapping
   @ApiOperation(value = "View a list of available bookings", response = List.class)
   public List<Booking> getAllBookings() {
      return bookingService.getAllBookings();
   }

   @GetMapping("/{id}")
   @ApiOperation(value = "Get a booking by Id")
   public ResponseEntity<Booking> getBookingById(@PathVariable("id") String id) {
      Optional<Booking> booking = bookingService.getBookingById(id);
      return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   @DeleteMapping("/{id}")
   @ApiOperation(value = "Delete a booking")
   public void deleteBooking(@PathVariable("id") String id) {
      bookingService.deleteBooking(id);
   }
}

