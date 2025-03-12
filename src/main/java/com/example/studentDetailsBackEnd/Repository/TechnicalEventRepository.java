package com.example.studentDetailsBackEnd.Repository;

import com.example.studentDetailsBackEnd.Model.TechnicalEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalEventRepository extends JpaRepository<TechnicalEvent, Long> {
    List<TechnicalEvent> findByStudentId(String studentId);
}