package com.yourpackage.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ClubMembership")
public class ClubMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer membership_id;

    @ManyToOne
    @JoinColumn(name = "Studentid")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "Clubid")
    private Club club;

    @Column(name = "Clubname", length = 100, nullable = false)
    private String clubname;

    @Column(name = "member_since")
    private Date memberSince;

    // Getters and Setters
    public Integer getMembership_id() {
        return membership_id;
    }

    public void setMembership_id(Integer membership_id) {
        this.membership_id = membership_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getClubname() {
        return clubname;
    }

    public void setClubname(String clubname) {
        this.clubname = clubname;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }
}
