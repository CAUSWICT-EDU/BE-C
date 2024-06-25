package com.yourpackage.repository;

import com.yourpackage.entity.Locker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LockerRepository extends JpaRepository<Locker, Integer> {
}
