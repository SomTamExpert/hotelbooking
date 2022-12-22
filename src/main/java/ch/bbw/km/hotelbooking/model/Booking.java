package ch.bbw.km.hotelbooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table()
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private Instant arrival;

    @NotNull
    @Column(nullable = false)
    private Instant checkout;

    @NotNull
    @Column(nullable = false)
    private Boolean breakfast = false;

    @Size(max = 255)
    @Column()
    private String comment;


    @ManyToOne()
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "room_id")
    private Room room;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getArrival() {
        return arrival;
    }

    public void setArrival(Instant arrival) {
        this.arrival = arrival;
    }

    public Instant getCheckout() {
        return checkout;
    }

    public void setCheckout(Instant checkout) {
        this.checkout = checkout;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Status getStatusStatusid() {
        return status;
    }

    public void setStatusStatusid(Status statusStatusid) {
        this.status = statusStatusid;
    }

    public User getUserUserid() {
        return user;
    }

    public void setUserUserid(User userUserid) {
        this.user = userUserid;
    }

    public Room getRoomRoomid() {
        return room;
    }

    public void setRoomRoomid(Room roomRoomid) {
        this.room = roomRoomid;
    }

}
