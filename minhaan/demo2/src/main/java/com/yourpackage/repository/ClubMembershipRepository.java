package com.yourpackage.repository;

import com.yourpackage.entity.ClubMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubMembershipRepository extends JpaRepository<ClubMembership, Integer> {
}
