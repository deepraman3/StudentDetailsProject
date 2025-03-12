package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Model.Publication;
import com.example.studentDetailsBackEnd.Service.PublicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {

    private final PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping("/submit")
    public Publication submitPublication(@RequestBody Publication publication) {
        return publicationService.submitPublication(publication);
    }

    @PutMapping("/approve/{id}")
    public String approvePublication(@PathVariable Long id) {
        return publicationService.approvePublication(id);
    }
}