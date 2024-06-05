package com.yourpackage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TermsandAgreement")
public class TermsAndAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "terms", length = 10000, nullable = false)
    private String terms;

    @Column(name = "version", nullable = false)
    private Integer version;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
