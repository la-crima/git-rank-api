package com.mallycrip.rank.infra.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String FROM_ADDRESS;

    @Override
    public void sendEmail(String address, String header, String content) {
        javaMailSender.send(generateEmail(address, header, content));
    }

    private SimpleMailMessage generateEmail(String address, String header, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(address);
        message.setFrom(FROM_ADDRESS);
        message.setSubject(header);
        message.setText(content);

        return message;
    }
}
