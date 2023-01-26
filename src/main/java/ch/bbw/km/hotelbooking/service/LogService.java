package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.logger.Log;
import ch.bbw.km.hotelbooking.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void log(String message, String level) {
        Log log = new Log();
        log.setMessage(message);
        log.setLevel(level);
        log.setTimestamp(new Date());
        logRepository.insert(log);
    }
}
