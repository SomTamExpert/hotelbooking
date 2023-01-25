package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Status;
import ch.bbw.km.hotelbooking.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class StatusController
 * @author Marco Karpf
 * @version 25.01.2023
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    /**
     * get all status
     * @return Iterable<Status>
     */
    @GetMapping
    public Iterable<Status> getAllStatuses() {
        return statusService.getStatuses();
    }

    /**
     * get status by id
     * @param id
     * @return status
     */
    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable int id) {
        return statusService.getStatusById(id);
    }

    /**
     * create status
     * @param status
     * @return status
     */
    @PostMapping
    public Status createStatus(Status status) {
        return statusService.createStatus(status);
    }

    /**
     * update status
     * @param id
     * @param status
     * @return status
     */
    @PutMapping("/{id}")
    public Status updateStatus(@PathVariable int id, Status status) {
        return statusService.updateStatus(id, status);
    }

    /**
     * delete status
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteStatusById(@PathVariable int id) {
        statusService.deleteStatus(id);
    }


}
