package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Model.TechnicalEvent;
import com.example.studentDetailsBackEnd.Service.TechnicalEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/events")
public class TechnicalEventController {

    @Autowired
    private TechnicalEventService technicalEventService;

    @GetMapping("/{studentId}")
    public String getEvents(@PathVariable String studentId, Model model) {
        List<TechnicalEvent> events = technicalEventService.getEventsByStudentId(studentId);
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/add")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new TechnicalEvent());
        model.addAttribute("categories", getEventCategories());
        return "add-event";
    }

    @PostMapping("/add")
    public String addEvent(
            @ModelAttribute("event") TechnicalEvent event,
            @RequestParam("certificate") MultipartFile certificate,
            Model model) {
        try {
            technicalEventService.addEvent(event, certificate);
            return "redirect:/events/" + event.getStudentId();
        } catch (IOException e) {
            model.addAttribute("error", "Error uploading file: " + e.getMessage());
            return "add-event";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        TechnicalEvent event = technicalEventService.getEventById(id);
        if (event != null) {
            model.addAttribute("event", event);
            model.addAttribute("categories", getEventCategories());
            return "edit-event";
        } else {
            return "redirect:/events";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(
            @PathVariable Long id,
            @ModelAttribute("event") TechnicalEvent event,
            @RequestParam("certificate") MultipartFile certificate,
            Model model) {
        try {
            technicalEventService.updateEvent(id, event, certificate);
            return "redirect:/events/" + event.getStudentId();
        } catch (IOException e) {
            model.addAttribute("error", "Error uploading file: " + e.getMessage());
            return "edit-event";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        try {
            technicalEventService.deleteEvent(id);
        } catch (IOException e) {
            // Handle deletion error
        }
        return "redirect:/events";
    }

    private List<String> getEventCategories() {
        // Return a list of event categories for the dropdown
        return List.of("Workshop", "Seminar", "Competition", "Other");
    }
}