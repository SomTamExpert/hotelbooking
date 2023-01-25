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

    /**
     * get booking by id
     * @return List<Booking>
     */
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }
    /**
     * get all bookings by user's email
     * @param email
     * @return List<Booking>
     */
    @GetMapping("/user/{email}")
    public List<Booking> getBookingByUserEmail(@PathVariable String email) {
        return bookingService.getBookingByUserEmail(email);
    }

    /**
     * get all bookings
     * @return List<Booking>
     */
    @GetMapping
    public Iterable<Booking> getAllBookings() {
        return bookingService.getBookings();
    }

    /**
     * create booking
     * @param booking
     * @return Booking
     */
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    /**
     * update booking
     * @param id
     * @param booking
     * @return Booking
     */
    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    /**
     * cancel booking
     * @param booking
     * @param id
     */
    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.cancelBooking(id, booking);
    }

    /**
     * confirm booking
     * @param id
     * @param booking
     * @return
     */
    @PutMapping("/confirm/{id}")
    public Booking confirmBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.confirmBooking(id, booking);
    }

    /**
     * delete booking
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
    }
}
