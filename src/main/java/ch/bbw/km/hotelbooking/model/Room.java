package ch.bbw.km.hotelbooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table()
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private Integer capacity;

    @Size(max = 255)
    @NotNull
    @Column(nullable = false)
    private String price;

    @NotNull
    @Column(nullable = false)
    private Boolean balcony = false;

    @NotNull
    @Column(nullable = false)
    private Boolean bathtub = false;

    @NotNull
    @Column(nullable = false)
    private Integer number;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getBalcony() {
        return balcony;
    }

    public void setBalcony(Boolean balcony) {
        this.balcony = balcony;
    }

    public Boolean getBathtub() {
        return bathtub;
    }
    public void setBathtub(Boolean bathtub) {
        this.bathtub = bathtub;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Category getCategoryCategoryid() {
        return category;
    }

    public void setCategoryCategoryid(Category categoryCategoryid) {
        this.category = categoryCategoryid;
    }

    public Status getStatusStatusid() {
        return status;
    }

    public void setStatusStatusid(Status statusStatusid) {
        this.status = statusStatusid;
    }

}
