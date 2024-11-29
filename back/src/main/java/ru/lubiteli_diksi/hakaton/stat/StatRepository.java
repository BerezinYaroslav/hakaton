package ru.lubiteli_diksi.hakaton.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatRepository extends JpaRepository<Stat, Integer> {

    @Query(value = "SELECT count(*) FROM channel where package = ?1", nativeQuery = true)
    Integer findChannelsCount(String packageName);
}
