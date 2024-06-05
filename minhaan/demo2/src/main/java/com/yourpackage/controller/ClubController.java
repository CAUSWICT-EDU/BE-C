package com.yourpackage.controller;

import com.yourpackage.entity.Club;
import com.yourpackage.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubService service;

    @GetMapping
    public List<Club> getAllClubs() {
        return service.getAllClubs();
    }

    @GetMapping("/{id}")
    public Club getClubById(@PathVariable Integer id) {
        return service.getClubById(id);
    }

    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return service.saveClub(club);
    }

    @PutMapping("/{id}")
    public Club updateClub(@PathVariable Integer id, @RequestBody Club club) {
        club.setId(id);
        return service.saveClub(club);
    }

    @DeleteMapping("/{id}")
    public void deleteClub(@PathVariable Integer id) {
        service.deleteClub(id);
    }
}
