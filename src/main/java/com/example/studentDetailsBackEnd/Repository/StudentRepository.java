package com.example.studentDetailsBackEnd.Repository;

import com.example.studentDetailsBackEnd.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Additional query methods can be defined here if needed
}