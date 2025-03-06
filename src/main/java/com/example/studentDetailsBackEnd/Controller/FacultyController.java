package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Service.FacultyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PutMapping("/approve/{studentId}")
    public String approveStudentRequest(@PathVariable Long studentId) {
        return facultyService.approveStudentRequest(studentId);
    }

    @PutMapping("/reject/{studentId}")
    public String rejectStudentRequest(@PathVariable Long studentId, @RequestParam String reason) {
        return facultyService.rejectStudentRequest(studentId, reason);
    }
}