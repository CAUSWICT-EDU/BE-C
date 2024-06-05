package com.yourpackage.controller;

import com.yourpackage.entity.LockerReservation;
import com.yourpackage.service.LockerReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lockerReservations")
public class LockerReservationController {
    @Autowired
    private LockerReservationService service;

    @GetMapping
    public List<LockerReservation> getAllLockerReservations() {
        return service.getAllLockerReservations();
    }

    @GetMapping("/{id}")
    public LockerReservation getLockerReservationById(@PathVariable Integer id) {
        return service.getLockerReservationById(id);
    }

    @PostMapping
    public LockerReservation createLockerReservation(@RequestBody LockerReservation lockerReservation) {
        return service.saveLockerReservation(lockerReservation);
    }

    @PutMapping("/{id}")
    public LockerReservation updateLockerReservation(@PathVariable Integer id, @RequestBody LockerReservation lockerReservation) {
        lockerReservation.setReservation_id(id);
        return service.saveLockerReservation(lockerReservation);
    }

    @DeleteMapping("/{id}")
    public void deleteLockerReservation(@PathVariable Integer id) {
        service.deleteLockerReservation(id);
    }
}
