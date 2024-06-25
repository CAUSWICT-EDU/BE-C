package com.yourpackage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Settings")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "preferences", length = 500, nullable = false)
    private String preferences;

    @OneToOne
    @JoinColumn(name = "Studentid")
    private Student student;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}