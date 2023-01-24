package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.model.Booking;
import ch.bbw.km.hotelbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking with id " + id + " not found"));
    }
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Iterable<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(int id, Booking booking) {
        Booking bookingToUpdate = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking with id " + id + " not found"));
        bookingToUpdate.setArrival(booking.getArrival());
        bookingToUpdate.setCheckout(booking.getCheckout());
        bookingToUpdate.setRoom(booking.getRoom());
        bookingToUpdate.setUser(booking.getUser());
        bookingToUpdate.setStatus(booking.getStatus());
        bookingToUpdate.setComment(booking.getComment());
        bookingToUpdate.setBreakfast(booking.getBreakfast());
        return bookingRepository.save(bookingToUpdate);
    }

    public void deleteBooking(int id) {
        Booking bookingToDelete = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking with id " + id + " not found"));
        bookingRepository.delete(bookingToDelete);
    }


    public List<Booking> getBookingByUserEmail(String email) {
        return bookingRepository.findByUserEmail(email);
    }
}
