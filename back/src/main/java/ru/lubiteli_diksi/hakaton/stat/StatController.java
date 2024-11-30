package ru.lubiteli_diksi.hakaton.stat;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = {"http://51.250.92.174:5173", "http://51.250.92.174", "http://freedom-dashboard-tv.ru", "http://localhost", "http://localhost:5173"}, allowedHeaders = "*")
public class StatController {
    private final StatService service;

    @GetMapping
    public List<Stat> getStats() {
        return service.getStats();
    }

    @GetMapping(value = "/devices")
    public List<Map<String, Integer>> getMostPopularDevices() {
        return service.getMostPopularDevices();
    }

    @GetMapping(value = "/channels")
    public List<Map<String, Integer>> getMostPopularChannels() {
        return service.getMostPopularChannels();
    }

    @GetMapping(value = "/categories")
    public List<Map<String, Integer>> getMostPopularCategories() {
        return service.getMostPopularDeviceCategories();
    }

    @GetMapping(value = "/subcategories")
    public List<Map<String, Integer>> getMostPopularSubcategories() {
        return service.getMostPopularDeviceSubcategories();
    }

    @GetMapping(value = "/channels/avgTime/{channel}")
    public Map<String, String> getAverageTimeByChannelPackage(@PathVariable String channel) {
        return service.getAverageTimeByChannelPackage(channel);
    }

    @GetMapping(value = "/gender/{gender}")
    public List<Stat> getGenderStats(@PathVariable String gender) {
        return service.getGenderStats(gender);
    }

    @GetMapping(value = "/age/{age}")
    public List<Stat> getAgeStats(@PathVariable String age) {
        return service.getAgeStats(age);
    }

    @GetMapping(value = "/elka/{age}")
    public Map<String, Integer> getAverageTimeByAgeAndCategory(@PathVariable String age) {
        return service.getAverageTimeByAgeAndCategory(age);
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
