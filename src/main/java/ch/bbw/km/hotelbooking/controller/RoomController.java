package ch.bbw.km.hotelbooking.controller;

import ch.bbw.km.hotelbooking.model.Room;
import ch.bbw.km.hotelbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class RoomController
 * @author Marco Karpf
 * @version 25.01.2023
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService roomService;

    /**
     * get all rooms
     * @return Iterable<Room>
     */
    @GetMapping()
    public Iterable<Room> getAllRooms() {
        return roomService.getRooms();
    }

    /**
     * get room by id
     * @param id
     * @return room
     */
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id) {
        return roomService.getRoomById(id);
    }

    /**
     * create room
     * @param room
     * @return room
     */
    @PostMapping
    public Room createRoom(Room room) {
        return roomService.createRoom(room);
    }

    /**
     * update room
     * @param id
     * @param room
     * @return room
     */
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable int id, Room room) {
        return roomService.updateRoom(id, room);
    }

    /**
     * delete room by id
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable int id) {
        roomService.deleteRoom(id);
    }
}
