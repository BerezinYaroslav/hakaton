package ru.lubiteli_diksi.hakaton.stat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lubiteli_diksi.hakaton.dto.PopularDeviceDTO;

import java.util.List;

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

    public List<PopularDeviceDTO> getPopularDevices() {
        return repository.getPopularDevices();
    }
}
