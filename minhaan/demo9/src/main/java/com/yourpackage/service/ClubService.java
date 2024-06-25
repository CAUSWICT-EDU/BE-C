package com.yourpackage.service;

import com.yourpackage.entity.Club;
import com.yourpackage.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubRepository repository;

    public List<Club> getAllClubs() {
        return repository.findAll();
    }

    public Club getClubById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Club saveClub(Club club) {
        return repository.save(club);
    }

    public void deleteClub(Integer id) {
        repository.deleteById(id);
    }
}
