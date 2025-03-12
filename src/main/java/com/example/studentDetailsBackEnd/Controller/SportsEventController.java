package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Model.SportsEvent;
import com.example.studentDetailsBackEnd.Service.SportsEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/sports-events")
public class SportsEventController {

    @Autowired
    private SportsEventService sportsEventService;

    @GetMapping("/{studentId}")
    public String getEvents(@PathVariable String studentId, Model model) {
        List<SportsEvent> events = sportsEventService.getEventsByStudentId(studentId);
        model.addAttribute("events", events);
        return "sports-events";
    }

    @GetMapping("/add")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new SportsEvent());
        model.addAttribute("categories", getEventCategories());
        return "add-sports-event";
    }

    @PostMapping("/add")
    public String addEvent(
            @ModelAttribute("event") SportsEvent event,
            @RequestParam("certificate") MultipartFile certificate,
            Model model) {
        try {
            sportsEventService.addEvent(event, certificate);
            return "redirect:/sports-events/" + event.getStudentId();
        } catch (IOException e) {
            model.addAttribute("error", "Error uploading file: " + e.getMessage());
            return "add-sports-event";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        SportsEvent event = sportsEventService.getEventById(id);
        if (event != null) {
            model.addAttribute("event", event);
            model.addAttribute("categories", getEventCategories());
            return "edit-sports-event";
        } else {
            return "redirect:/sports-events";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(
            @PathVariable Long id,
            @ModelAttribute("event") SportsEvent event,
            @RequestParam("certificate") MultipartFile certificate,
            Model model) {
        try {
            sportsEventService.updateEvent(id, event, certificate);
            return "redirect:/sports-events/" + event.getStudentId();
        } catch (IOException e) {
            model.addAttribute("error", "Error uploading file: " + e.getMessage());
            return "edit-sports-event";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        try {
            sportsEventService.deleteEvent(id);
        } catch (IOException e) {
            // Handle deletion error
        }
        return "redirect:/sports-events";
    }

    private List<String> getEventCategories() {
        // Return a list of event categories for the dropdown
        return List.of("Tournament", "Match", "Practice", "Other");
    }
}