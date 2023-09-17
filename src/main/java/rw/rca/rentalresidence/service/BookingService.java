package rw.rca.rentalresidence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import rw.rca.rentalresidence.model.Booking;
import rw.rca.rentalresidence.repository.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
   private final BookingRepository bookingRepository;

   @Autowired
   public BookingService(BookingRepository bookingRepository) {
      this.bookingRepository = bookingRepository;
   }

   public Booking createBooking(Booking booking) {
      return bookingRepository.save(booking);
   }

   public List<Booking> getAllBookings() {
      return bookingRepository.findAll();
   }
   public Page<Booking> getAllBookings(Pageable pageable) {
      return bookingRepository.findAll(pageable);
   }

   public Optional<Booking> getBookingById(String id) {
      return bookingRepository.findById(id);
   }

   public void deleteBooking(String id) {
      bookingRepository.deleteById(id);
   }
}

