package com.yourpackage.service;

import com.yourpackage.entity.ClubMembership;
import com.yourpackage.repository.ClubMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubMembershipService {
    @Autowired
    private ClubMembershipRepository repository;

    public List<ClubMembership> getAllClubMemberships() {
        return repository.findAll();
    }

    public ClubMembership getClubMembershipById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public ClubMembership saveClubMembership(ClubMembership clubMembership) {
        return repository.save(clubMembership);
    }

    public void deleteClubMembership(Integer id) {
        repository.deleteById(id);
    }
}
