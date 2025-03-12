package com.example.studentDetailsBackEnd.Service;

import com.example.studentDetailsBackEnd.Model.Publication;
import com.example.studentDetailsBackEnd.Repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PublicationService {

    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public Publication submitPublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public String approvePublication(Long id) {
        Optional<Publication> optionalPublication = publicationRepository.findById(id);
        if (optionalPublication.isPresent()) {
            Publication publication = optionalPublication.get();
            publication.setApproved(true); // Assuming there's a field 'approved' in Publication
            publicationRepository.save(publication);
            return "Publication approved successfully.";
        } else {
            return "Publication not found.";
        }
    }
}