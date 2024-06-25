package com.yourpackage.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Locker")
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @OneToMany(mappedBy = "locker")
    private List<LockerReservation> lockerReservations;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public List<LockerReservation> getLockerReservations() {
        return lockerReservations;
    }

    public void setLockerReservations(List<LockerReservation> lockerReservations) {
        this.lockerReservations = lockerReservations;
    }
}
