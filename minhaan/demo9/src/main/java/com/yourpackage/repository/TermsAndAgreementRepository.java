package com.yourpackage.repository;

import com.yourpackage.entity.TermsAndAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsAndAgreementRepository extends JpaRepository<TermsAndAgreement, Integer> {
}
