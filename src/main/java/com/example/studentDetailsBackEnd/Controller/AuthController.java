package com.example.studentDetailsBackEnd.Controller;

import com.example.studentDetailsBackEnd.Service.AuthService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login(OidcUser user) {
        return authService.login(user);
    }

    @GetMapping("/logout-success")
    public String logoutSuccess() {
        return "Logged out successfully!";
    }
}