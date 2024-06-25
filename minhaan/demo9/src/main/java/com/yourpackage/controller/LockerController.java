package com.yourpackage.controller;

import com.yourpackage.entity.Locker;
import com.yourpackage.service.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lockers")
public class LockerController {
    @Autowired
    private LockerService service;

    @GetMapping
    public List<Locker> getAllLockers() {
        return service.getAllLockers();
    }

    @GetMapping("/{id}")
    public Locker getLockerById(@PathVariable Integer id) {
        return service.getLockerById(id);
    }

    @PostMapping
    public Locker createLocker(@RequestBody Locker locker) {
        return service.saveLocker(locker);
    }

    @PutMapping("/{id}")
    public Locker updateLocker(@PathVariable Integer id, @RequestBody Locker locker) {
        locker.setId(id);
        return service.saveLocker(locker);
    }

    @DeleteMapping("/{id}")
    public void deleteLocker(@PathVariable Integer id) {
        service.deleteLocker(id);
    }
}
