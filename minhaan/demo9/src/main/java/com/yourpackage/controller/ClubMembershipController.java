package com.yourpackage.controller;

import com.yourpackage.entity.ClubMembership;
import com.yourpackage.service.ClubMembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubMemberships")
public class ClubMembershipController {
    @Autowired
    private ClubMembershipService service;

    @GetMapping
    public List<ClubMembership> getAllClubMemberships() {
        return service.getAllClubMemberships();
    }

    @GetMapping("/{id}")
    public ClubMembership getClubMembershipById(@PathVariable Integer id) {
        return service.getClubMembershipById(id);
    }

    @PostMapping
    public ClubMembership createClubMembership(@RequestBody ClubMembership clubMembership) {
        return service.saveClubMembership(clubMembership);
    }

    @PutMapping("/{id}")
    public ClubMembership updateClubMembership(@PathVariable Integer id, @RequestBody ClubMembership clubMembership) {
        clubMembership.setMembership_id(id);
        return service.saveClubMembership(clubMembership);
    }

    @DeleteMapping("/{id}")
    public void deleteClubMembership(@PathVariable Integer id) {
        service.deleteClubMembership(id);
    }
}
