package ru.lubiteli_diksi.hakaton.stat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatService {
    private final StatRepository repository;

    public Stat addStat(Stat stat) {
        log.info("add a stat");
        return repository.save(stat);
    }

    public List<Stat> getStats() {
        log.info("get stats");
        return repository.findAll();
    }

    public List<Map<String, Integer>> getMostPopularDevices() {
        return repository.findMostPopularDevices();
    }

    public List<Map<String, Integer>> getMostPopularChannels() {
        return repository.findMostPopularChannels();
    }

    public List<Map<String, Integer>> getMostPopularDeviceCategories() {
        return repository.findMostPopularCategories();
    }

    public List<Map<String, Integer>> getMostPopularDeviceSubcategories() {
        return repository.findMostPopularSubcategories();
    }

    public List<Stat> getGenderStats(String gender) {
        if (gender.equals("М")) {
            gender = "M";
        }

        return repository.findGenderStats(gender);
    }

    public List<Stat> getAgeStats(String age) {
        return repository.findAgeStats(age);
    }

    public Stat findStatById(Integer id) {
        log.info("get stat where id = {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no a id " + id));
    }

    public Stat updateStat(Stat stat) {
        log.info("update a stat");
        return repository.save(stat);
    }

    public void deleteStats() {
        log.info("Delete stats");
        repository.deleteAll();
    }

    public void deleteStatById(Integer id) {
        log.info("Delete a stat with id " + id);
        repository.deleteById(id);
    }
}
