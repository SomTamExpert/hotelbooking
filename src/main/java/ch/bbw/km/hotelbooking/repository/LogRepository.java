package ch.bbw.km.hotelbooking.repository;


import ch.bbw.km.hotelbooking.logger.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, String> {

}
