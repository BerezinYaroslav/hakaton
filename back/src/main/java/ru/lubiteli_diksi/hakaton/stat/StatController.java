package ru.lubiteli_diksi.hakaton.stat;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class StatController {
    private final StatService service;

    @GetMapping
    public List<Stat> getStats() {
        return service.getStats();
    }

    @GetMapping(value = "/{id}")
    public Stat getStatById(@PathVariable Integer id) {
        return service.findStatById(id);
    }

    @PostMapping(produces = "application/json")
    public Stat addStat(@RequestBody @Valid Stat stat) {
        return service.addStat(stat);
    }

    @PutMapping(produces = "application/json")
    public Stat updateStat(@RequestBody @Valid Stat stat) {
        return service.updateStat(stat);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteStats() {
        service.deleteStats();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteStatById(@PathVariable Integer id) {
        service.deleteStatById(id);
    }
}
