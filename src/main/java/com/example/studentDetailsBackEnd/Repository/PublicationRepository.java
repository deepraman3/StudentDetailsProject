package com.example.studentDetailsBackEnd.Repository;

import com.example.studentDetailsBackEnd.Model.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    // Additional query methods can be defined here if needed
}
