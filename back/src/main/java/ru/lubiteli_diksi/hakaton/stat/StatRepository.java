package ru.lubiteli_diksi.hakaton.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface StatRepository extends JpaRepository<Stat, Integer> {
    @Query(value = "SELECT device, COUNT(*) " +
            "FROM stat " +
            "group by device " +
            "order by COUNT(*) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularDevices();

    @Query(value = "SELECT channel_id, SUM(duration) " +
            "FROM stat " +
            "group by channel_id " +
            "order by SUM(duration) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularChannels();

    @Query(value = "SELECT category, SUM(duration) " +
            "FROM stat " +
            "group by category " +
            "order by SUM(duration) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularCategories();

    @Query(value = "SELECT subcategory, SUM(duration) " +
            "FROM stat " +
            "group by subcategory " +
            "order by SUM(duration) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularSubcategories();
}
