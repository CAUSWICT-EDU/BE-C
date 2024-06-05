package com.yourpackage.entity;


import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dateJoined")
    private Date dateJoined;

    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "password", length = 100, nullable = false)
    private String password;

    @Column(name = "name", length = 30)
    private String name;

    @OneToMany(mappedBy = "student")
    private List<ClubMembership> clubMemberships;

    @OneToMany(mappedBy = "student")
    private List<LockerReservation> lockerReservations;

    @OneToMany(mappedBy = "student")
    private List<Post> posts;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Settings settings;

    @ManyToOne
    @JoinColumn(name = "terms_and_agreement_id")
    private TermsAndAgreement termsAndAgreement;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClubMembership> getClubMemberships() {
        return clubMemberships;
    }

    public void setClubMemberships(List<ClubMembership> clubMemberships) {
        this.clubMemberships = clubMemberships;
    }

    public List<LockerReservation> getLockerReservations() {
        return lockerReservations;
    }

    public void setLockerReservations(List<LockerReservation> lockerReservations) {
        this.lockerReservations = lockerReservations;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public TermsAndAgreement getTermsAndAgreement() {
        return termsAndAgreement;
    }

    public void setTermsAndAgreement(TermsAndAgreement termsAndAgreement) {
        this.termsAndAgreement = termsAndAgreement;
    }
}

