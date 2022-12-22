package ch.bbw.km.hotelbooking.repository;

import ch.bbw.km.hotelbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
