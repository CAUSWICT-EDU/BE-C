package com.yourpackage.repository;


import com.yourpackage.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent() {
        // Given
        Student student = new Student();
        student.setUsername("johndoe");
        student.setEmail("johndoe@example.com");
        student.setPassword("password");
        student.setName("John Doe");
        student.setDateJoined(new Date());

        // When
        Student savedStudent = studentRepository.save(student);

        // Then
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getId()).isNotNull();
    }

    @Test
    public void testFindStudentById() {
        // Given
        Student student = new Student();
        student.setUsername("janedoe");
        student.setEmail("janedoe@example.com");
        student.setPassword("password");
        student.setName("Jane Doe");
        student.setDateJoined(new Date());
        Student savedStudent = studentRepository.save(student);

        // When
        Optional<Student> foundStudent = studentRepository.findById(savedStudent.getId());

        // Then
        assertThat(foundStudent).isPresent();
        assertThat(foundStudent.get().getUsername()).isEqualTo("janedoe");
    }

    @Test
    public void testUpdateStudent() {
        // Given
        Student student = new Student();
        student.setUsername("janedoe");
        student.setEmail("janedoe@example.com");
        student.setPassword("password");
        student.setName("Jane Doe");
        student.setDateJoined(new Date());
        Student savedStudent = studentRepository.save(student);

        // When
        savedStudent.setEmail("janedoe_updated@example.com");
        Student updatedStudent = studentRepository.save(savedStudent);

        // Then
        assertThat(updatedStudent.getEmail()).isEqualTo("janedoe_updated@example.com");
    }

    @Test
    public void testDeleteStudent() {
        // Given
        Student student = new Student();
        student.setUsername("janedoe");
        student.setEmail("janedoe@example.com");
        student.setPassword("password");
        student.setName("Jane Doe");
        student.setDateJoined(new Date());
        Student savedStudent = studentRepository.save(student);

        // When
        studentRepository.deleteById(savedStudent.getId());
        Optional<Student> deletedStudent = studentRepository.findById(savedStudent.getId());

        // Then
        assertThat(deletedStudent).isNotPresent();
    }
}
