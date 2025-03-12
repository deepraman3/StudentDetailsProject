package com.example.studentDetailsBackEnd.Repository;

import com.example.studentDetailsBackEnd.Model.SportsEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsEventRepository extends JpaRepository<SportsEvent, Long> {
    List<SportsEvent> findByStudentId(String studentId);
}