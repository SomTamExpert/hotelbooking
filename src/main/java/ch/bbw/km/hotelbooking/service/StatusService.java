package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.model.Status;
import ch.bbw.km.hotelbooking.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public Iterable<Status> getStatuses() {
        return statusRepository.findAll();
    }

    public Status getStatusById(int id) {
        return statusRepository.findById(id).orElseThrow(() -> new RuntimeException("Status with id " + id + " not found"));
    }

    public Status createStatus(Status status) {
        return statusRepository.save(status);
    }

    public Status updateStatus(int id, Status status) {
        Status statusToUpdate = statusRepository.findById(id).orElseThrow(() -> new RuntimeException("Status with id " + id + " not found"));
        statusToUpdate.setStatus(status.getStatus());
        return statusRepository.save(statusToUpdate);
    }

    public void deleteStatus(int id) {
        Status statusToDelete = statusRepository.findById(id).orElseThrow(() -> new RuntimeException("Status with id " + id + " not found"));
        statusRepository.delete(statusToDelete);
    }
}
