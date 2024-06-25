package com.yourpackage.service;

import com.yourpackage.entity.TermsAndAgreement;
import com.yourpackage.repository.TermsAndAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermsAndAgreementService {
    @Autowired
    private TermsAndAgreementRepository repository;

    public List<TermsAndAgreement> getAllTerms() {
        return repository.findAll();
    }

    public TermsAndAgreement getTermsById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public TermsAndAgreement saveTerms(TermsAndAgreement termsAndAgreement) {
        return repository.save(termsAndAgreement);
    }

    public void deleteTerms(Integer id) {
        repository.deleteById(id);
    }
}
