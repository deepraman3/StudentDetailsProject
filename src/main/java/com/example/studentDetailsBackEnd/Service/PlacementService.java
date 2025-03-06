package com.example.studentDetailsBackEnd.Service;

import com.example.studentDetailsBackEnd.Model.Placement;
import com.example.studentDetailsBackEnd.Repository.PlacementRepository;
import org.springframework.stereotype.Service;

@Service
public class PlacementService {

    private final PlacementRepository placementRepository;

    public PlacementService(PlacementRepository placementRepository) {
        this.placementRepository = placementRepository;
    }

    public Placement uploadOfferLetter(Placement placement) {
        placement.setStatus("PENDING");
        return placementRepository.save(placement);
    }

    public String approvePlacement(Long id) {
        Placement placement = placementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Placement not found"));
        placement.setStatus("APPROVED");
        placementRepository.save(placement);
        return "Placement approved";
    }
}