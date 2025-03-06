package com.example.studentDetailsBackEnd.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String rollNumber;
    private String department;
    private String email;
    private String status; // APPROVED, REJECTED, PENDING
}