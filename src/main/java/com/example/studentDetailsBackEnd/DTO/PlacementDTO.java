package com.example.studentDetailsBackEnd.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlacementDTO {
    private Long id;
    private String companyName;
    private String role;
    private String offerLetterLink;
    private String status;
}