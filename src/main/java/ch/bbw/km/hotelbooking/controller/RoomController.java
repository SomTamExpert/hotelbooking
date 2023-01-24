package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Room;
import ch.bbw.km.hotelbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping()
    public Iterable<Room> getAllRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Room createRoom(Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable int id, Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable int id) {
        roomService.deleteRoom(id);
    }
}
