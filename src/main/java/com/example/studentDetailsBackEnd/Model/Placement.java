package com.example.studentDetailsBackEnd.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "placements")
public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private String companyName;
    private String role;
    private String offerLetterLink;
    private String status; // PENDING, APPROVED, REJECTED
}