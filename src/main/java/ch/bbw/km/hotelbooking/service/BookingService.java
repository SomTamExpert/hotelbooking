package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.model.Booking;
import ch.bbw.km.hotelbooking.model.Status;
import ch.bbw.km.hotelbooking.repository.BookingRepository;
import ch.bbw.km.hotelbooking.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private StatusRepository statusRepository;


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
        bookingToUpdate.setUser(bookingToUpdate.getUser());
        bookingToUpdate.setArrival(booking.getArrival());
        bookingToUpdate.setCheckout(booking.getCheckout());
        bookingToUpdate.setRoom(booking.getRoom());
        bookingToUpdate.setUser(bookingToUpdate.getUser());
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

    public Booking cancelBooking(int id, Booking booking) {
        Booking bookingToUpdate = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking with id " + id + " not found"));
        bookingToUpdate.setUser(bookingToUpdate.getUser());
        bookingToUpdate.setArrival(booking.getArrival());
        bookingToUpdate.setCheckout(booking.getCheckout());
        bookingToUpdate.setRoom(booking.getRoom());
        bookingToUpdate.setUser(bookingToUpdate.getUser());
        Status cancelledStatus = statusRepository.findByStatus("cancelled");
        bookingToUpdate.setStatus(cancelledStatus);
        bookingToUpdate.setComment(booking.getComment());
        bookingToUpdate.setBreakfast(booking.getBreakfast());
        return bookingRepository.save(bookingToUpdate);
    }

    public Booking confirmBooking(int id, Booking booking) {
        Booking bookingToUpdate = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking with id " + id + " not found"));
        bookingToUpdate.setUser(bookingToUpdate.getUser());
        bookingToUpdate.setArrival(booking.getArrival());
        bookingToUpdate.setCheckout(booking.getCheckout());
        bookingToUpdate.setRoom(booking.getRoom());
        bookingToUpdate.setUser(bookingToUpdate.getUser());
        Status confirmedStatus = statusRepository.findByStatus("confirmed");
        bookingToUpdate.setStatus(confirmedStatus);
        bookingToUpdate.setComment(booking.getComment());
        bookingToUpdate.setBreakfast(booking.getBreakfast());
        return bookingRepository.save(bookingToUpdate);
    }
}
