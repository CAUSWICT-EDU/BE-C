package com.yourpackage.controller;

import com.yourpackage.entity.TermsAndAgreement;
import com.yourpackage.service.TermsAndAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/terms")
public class TermsAndAgreementController {
    @Autowired
    private TermsAndAgreementService service;

    @GetMapping
    public List<TermsAndAgreement> getAllTerms() {
        return service.getAllTerms();
    }

    @GetMapping("/{id}")
    public TermsAndAgreement getTermsById(@PathVariable Integer id) {
        return service.getTermsById(id);
    }

    @PostMapping
    public TermsAndAgreement createTerms(@RequestBody TermsAndAgreement termsAndAgreement) {
        return service.saveTerms(termsAndAgreement);
    }

    @PutMapping("/{id}")
    public TermsAndAgreement updateTerms(@PathVariable Integer id, @RequestBody TermsAndAgreement termsAndAgreement) {
        termsAndAgreement.setId(id);
        return service.saveTerms(termsAndAgreement);
    }

    @DeleteMapping("/{id}")
    public void deleteTerms(@PathVariable Integer id) {
        service.deleteTerms(id);
    }
}
