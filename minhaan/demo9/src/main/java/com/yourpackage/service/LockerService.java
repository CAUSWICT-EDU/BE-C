package com.yourpackage.service;

import com.yourpackage.entity.Locker;
import com.yourpackage.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LockerService {
    @Autowired
    private LockerRepository repository;

    public List<Locker> getAllLockers() {
        return repository.findAll();
    }

    public Locker getLockerById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Locker saveLocker(Locker locker) {
        return repository.save(locker);
    }

    public void deleteLocker(Integer id) {
        repository.deleteById(id);
    }
}
