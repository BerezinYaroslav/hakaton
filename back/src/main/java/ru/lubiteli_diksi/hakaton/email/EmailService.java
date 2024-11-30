package ru.lubiteli_diksi.hakaton.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Value("#{'${spring.mail.recipients}'.split(', ')}")
    private List<String> recipients;

    @Value("${spring.mail.subject}")
    private String subject;

    private SimpleMailMessage setMailMessage() {
        return new SimpleMailMessage();
    }

    public void sendEmail(String message) {
        SimpleMailMessage mailMessage = setMailMessage();

        mailMessage.setText(message);
        mailMessage.setFrom(username);
        mailMessage.setTo(recipients.toArray(String[]::new));
        mailMessage.setSubject(subject);

        log.info("Sending email with subject '{}' and text: {}", subject, message);
        mailSender.send(mailMessage);
        log.info("Email with subject '{}' sent successfully", subject);
    }
}

