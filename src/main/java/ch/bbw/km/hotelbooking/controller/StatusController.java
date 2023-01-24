package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Status;
import ch.bbw.km.hotelbooking.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping
    public Iterable<Status> getAllStatuses() {
        return statusService.getStatuses();
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable int id) {
        return statusService.getStatusById(id);
    }

    @PostMapping
    public Status createStatus(Status status) {
        return statusService.createStatus(status);
    }

    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable int id, Status status) {
        return statusService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteStatusById(@PathVariable int id) {
        statusService.deleteStatus(id);
    }


}
