package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Model.Placement;
import com.example.studentDetailsBackEnd.Service.PlacementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    private final PlacementService placementService;

    public PlacementController(PlacementService placementService) {
        this.placementService = placementService;
    }

    @PostMapping("/upload")
    public Placement uploadOfferLetter(@RequestBody Placement placement) {
        return placementService.uploadOfferLetter(placement);
    }

    @PutMapping("/approve/{id}")
    public String approvePlacement(@PathVariable Long id) {
        return placementService.approvePlacement(id);
    }
}