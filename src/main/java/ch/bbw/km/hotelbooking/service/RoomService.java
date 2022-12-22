package ch.bbw.km.hotelbooking.service;

import ch.bbw.km.hotelbooking.model.Room;
import ch.bbw.km.hotelbooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room getRoomById(int id) {
        return roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room with id " + id + " not found"));
    }

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public Iterable<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room updateRoom(int id, Room room) {
        Room roomToUpdate = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room with id " + id + " not found"));
        roomToUpdate.setNumber(room.getNumber());
        roomToUpdate.setBalcony(room.getBalcony());
        roomToUpdate.setBathtub(room.getBathtub());
        roomToUpdate.setCapacity(room.getCapacity());
        roomToUpdate.setPrice(room.getPrice());
        roomToUpdate.setCategory(room.getCategory());
        return roomRepository.save(roomToUpdate);
    }

    public void deleteRoom(int id) {
        Room roomToDelete = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room with id " + id + " not found"));
        roomRepository.delete(roomToDelete);
    }
}
