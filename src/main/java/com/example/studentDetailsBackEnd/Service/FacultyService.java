package com.example.studentDetailsBackEnd.Service;

import com.example.studentDetailsBackEnd.Model.Student;
import com.example.studentDetailsBackEnd.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    private final StudentRepository studentRepository;

    public FacultyService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String approveStudentRequest(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setStatus("APPROVED");
        studentRepository.save(student);
        return "Student request approved";
    }

    public String rejectStudentRequest(Long studentId, String reason) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.setStatus("REJECTED: " + reason);
        studentRepository.save(student);
        return "Student request rejected";
    }
}