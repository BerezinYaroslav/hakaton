package ru.lubiteli_diksi.hakaton.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.lubiteli_diksi.hakaton.dto.PopularDeviceDTO;

import java.util.List;

public interface StatRepository extends JpaRepository<Stat, Integer> {

    @Query(value = "SELECT device, COUNT(*) AS device_count " +
                   "FROM stat "    +
                   "GROUP BY device " +
                   "ORDER BY device_count DESC " +
                   "LIMIT 5", nativeQuery = true)
    List<PopularDeviceDTO> getPopularDevices();
}
