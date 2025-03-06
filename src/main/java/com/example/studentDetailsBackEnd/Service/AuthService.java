package com.example.studentDetailsBackEnd.Service;

import com.example.studentDetailsBackEnd.Model.User;
import com.example.studentDetailsBackEnd.Repository.UserRepository;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(OidcUser oidcUser) {
        User user = userRepository.findByEmail(oidcUser.getEmail())
                .orElseGet(() -> userRepository.save(new User(oidcUser.getEmail(), "STUDENT")));
        return "Logged in as: " + user.getEmail();
    }
}