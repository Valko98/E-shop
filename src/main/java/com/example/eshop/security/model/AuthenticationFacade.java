package com.example.eshop.security.model;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {
      return SecurityContextHolder.getContext().getAuthentication();
    }
}
