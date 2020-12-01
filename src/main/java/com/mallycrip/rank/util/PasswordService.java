package com.mallycrip.rank.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordService {
    public String encode(String password) {
        return passwordEncoder().encode(password);
    }

    public boolean matches(String password, String hashedPassword) {
        return passwordEncoder().matches(password, hashedPassword);
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
