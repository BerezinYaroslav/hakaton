package ru.lubiteli_diksi.hakaton.stat;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class StatController {
    private final StatRepository repository;

    @GetMapping
    public List<Stat> getStats() {
        return repository.findAll();
    }
}
