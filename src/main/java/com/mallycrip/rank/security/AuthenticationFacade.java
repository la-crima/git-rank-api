package com.mallycrip.rank.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public String getEmail() {
        Authentication auth = this.getAuthentication();
        if (auth.getPrincipal() instanceof AuthDetails) {
            return ((AuthDetails) auth.getPrincipal()).getUser().getEmail();
        } else {
            return this.getAuthentication().getName();
        }
    }
}
