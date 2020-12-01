package com.mallycrip.rank.infra.email;

import org.springframework.stereotype.Component;

public interface EmailService {
    public void sendEmail(String address, String header, String content);
}
