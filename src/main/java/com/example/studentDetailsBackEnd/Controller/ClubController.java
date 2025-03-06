package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Model.Club;
import com.example.studentDetailsBackEnd.Service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @PostMapping("/view")
    public Club viewClub(@RequestBody Club club) {
        return clubService.viewClub(club);
    }
}