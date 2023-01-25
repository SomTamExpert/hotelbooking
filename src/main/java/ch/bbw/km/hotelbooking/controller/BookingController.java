package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Booking;
import ch.bbw.km.hotelbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *Class BookingController
 * @author marco karpf
 * @version 23.12.22
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("/user/{email}")
    public List<Booking> getBookingByUserEmail(@PathVariable String email) {
        return bookingService.getBookingByUserEmail(email);
    }

    @GetMapping
    public Iterable<Booking> getAllBookings() {
        return bookingService.getBookings();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.cancelBooking(id, booking);
    }

    @PutMapping("/confirm/{id}")
    public Booking confirmBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.confirmBooking(id, booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
}
