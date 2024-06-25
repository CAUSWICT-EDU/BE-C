package com.yourpackage.service;

import com.yourpackage.entity.LockerReservation;
import com.yourpackage.repository.LockerReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerReservationService {
    @Autowired
    private LockerReservationRepository repository;

    public List<LockerReservation> getAllLockerReservations() {
        return repository.findAll();
    }

    public LockerReservation getLockerReservationById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public LockerReservation saveLockerReservation(LockerReservation lockerReservation) {
        return repository.save(lockerReservation);
    }

    public void deleteLockerReservation(Integer id) {
        repository.deleteById(id);
    }
}
