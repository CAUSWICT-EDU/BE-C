package com.yourpackage.repository;

import com.yourpackage.entity.LockerReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerReservationRepository extends JpaRepository<LockerReservation, Integer> {
}
