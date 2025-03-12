package com.example.studentDetailsBackEnd.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "sports_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SportsEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentId; // Foreign key to identify student

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private String eventCategory;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String role;

    private String achievement;

    @Column(columnDefinition = "TEXT")
    private String achievementDetails;

    @Column(columnDefinition = "TEXT")
    private String otherDetails;

    private String certificatePath; // Store file path for certificate
}