package com.example.studentDetailsBackEnd.Service;

import com.example.studentDetailsBackEnd.Model.TechnicalEvent;
import com.example.studentDetailsBackEnd.Repository.TechnicalEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TechnicalEventService {

    @Autowired
    private TechnicalEventRepository technicalEventRepository;

    private final String uploadDir = "uploads/certificates/";

    public List<TechnicalEvent> getEventsByStudentId(String studentId) {
        return technicalEventRepository.findByStudentId(studentId);
    }

    public TechnicalEvent getEventById(Long id) {
        return technicalEventRepository.findById(id).orElse(null);
    }

    public TechnicalEvent addEvent(TechnicalEvent event, MultipartFile certificateFile) throws IOException {
        if (!certificateFile.isEmpty()) {
            String filePath = saveCertificate(certificateFile);
            event.setCertificatePath(filePath);
        }
        return technicalEventRepository.save(event);
    }

    public TechnicalEvent updateEvent(Long id, TechnicalEvent updatedEvent, MultipartFile certificateFile) throws IOException {
        Optional<TechnicalEvent> existing = technicalEventRepository.findById(id);
        if (existing.isPresent()) {
            TechnicalEvent event = existing.get();
            event.setEventName(updatedEvent.getEventName());
            event.setEventCategory(updatedEvent.getEventCategory());
            event.setDate(updatedEvent.getDate());
            event.setRole(updatedEvent.getRole());
            event.setAchievement(updatedEvent.getAchievement());
            event.setAchievementDetails(updatedEvent.getAchievementDetails());
            event.setOtherDetails(updatedEvent.getOtherDetails());

            if (!certificateFile.isEmpty()) {
                // Delete the old certificate if it exists
                if (event.getCertificatePath() != null) {
                    Files.deleteIfExists(Paths.get(event.getCertificatePath()));
                }
                String filePath = saveCertificate(certificateFile);
                event.setCertificatePath(filePath);
            }

            return technicalEventRepository.save(event);
        }
        return null;
    }

    public void deleteEvent(Long id) throws IOException {
        Optional<TechnicalEvent> existing = technicalEventRepository.findById(id);
        if (existing.isPresent()) {
            TechnicalEvent event = existing.get();
            // Delete the certificate file if it exists
            if (event.getCertificatePath() != null) {
                Files.deleteIfExists(Paths.get(event.getCertificatePath()));
            }
            technicalEventRepository.deleteById(id);
        }
    }

    private String saveCertificate(MultipartFile file) throws IOException {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        File destinationFile = new File(uploadDir + fileName);
        file.transferTo(destinationFile);
        return destinationFile.getAbsolutePath();
    }
}