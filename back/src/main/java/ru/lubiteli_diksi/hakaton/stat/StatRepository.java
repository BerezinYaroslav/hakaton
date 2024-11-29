package ru.lubiteli_diksi.hakaton.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatRepository extends JpaRepository<Stat, Integer> {
    @Query(value =
            "SELECT device FROM stat " +
            "group by device " +
            "order by COUNT(*) desc limit 5", nativeQuery = true)
    List<String> findMostPopularDevices();
}
