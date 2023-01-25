package ch.bbw.km.hotelbooking.repository;

import ch.bbw.km.hotelbooking.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByStatus(String cancelled);
}
