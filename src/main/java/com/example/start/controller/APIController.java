package com.example.start.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableMethodSecurity(jsr250Enabled = true)
public class APIController {

    @GetMapping("/public/api")
    public String publicApi() {
        return "Public access";
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/admin/api")
    public String adminApi(Authentication authentication) {
        return "Admin API: пользователь " + authentication.getName() + ", роль " + authentication.getAuthorities();
    }

    @RolesAllowed("SUPPORT")
    @GetMapping("/support/api")
    public String supportApi(Authentication authentication) {
        return "Support API: пользователь " + authentication.getName() + ", роль " + authentication.getAuthorities();
    }
}
