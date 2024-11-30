package ru.lubiteli_diksi.hakaton.email;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = {"http://51.250.92.174:5173", "http://51.250.92.174", "http://freedom-dashboard-tv.ru", "http://localhost", "http://localhost:5173"}, allowedHeaders = "*")
public class EmailController {
    private final EmailService emailService;

    @PostMapping(value = "/{message}")
    public void sendEmail(@PathVariable String message) {
        emailService.sendEmail(message);
    }
}
