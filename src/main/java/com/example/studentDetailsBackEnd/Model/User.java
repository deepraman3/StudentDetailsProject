package com.example.studentDetailsBackEnd.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String role; // STUDENT, FACULTY, ADMIN

    public User(String email, String role) {
        this.email = email;
        this.role = role;
    }
}