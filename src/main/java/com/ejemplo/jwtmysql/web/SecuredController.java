package com.ejemplo.jwtmysql.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SecuredController {

    @GetMapping("/secured")
    public Map<String, Object> secured(Authentication authentication) {
        return Map.of(
                "message", "Acceso concedido al recurso protegido con JWT",
                "user", authentication.getName(),
                "authorities", authentication.getAuthorities()
        );
    }
}