package ru.lubiteli_diksi.hakaton.stat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface StatRepository extends JpaRepository<Stat, Integer> {
    @Query(value = "select device, COUNT(*) " +
            "from stat " +
            "group by device " +
            "order by COUNT(*) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularDevices();

    @Query(value = "select channel_id, SUM(duration) " +
            "from stat " +
            "group by channel_id " +
            "order by SUM(duration) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularChannels();

    @Query(value = "select category, SUM(duration) " +
            "from stat " +
            "group by category " +
            "order by SUM(duration) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularCategories();

    @Query(value = "select subcategory, SUM(duration) " +
            "from stat " +
            "group by subcategory " +
            "order by SUM(duration) desc " +
            "limit 5", nativeQuery = true)
    List<Map<String, Integer>> findMostPopularSubcategories();

    @Query(value = "select s.* " +
            "from stat s " +
            "left join client c on c.client = s.client " +
            "where c.gender = ?1", nativeQuery = true)
    List<Stat> findGenderStats(String gender);

    @Query(value = "select s.* " +
            "from stat s " +
            "left join client c on c.client = s.client " +
            "where c.age = ?1", nativeQuery = true)
    List<Stat> findAgeStats(String age);

    @Query(value = "select avg(s.duration) " +
            "from stat s " +
            "left join client c on c.client = s.client " +
            "where c.age = ?1 " +
            "and s.category = ?2", nativeQuery = true)
    Integer findAverageTimeByAgeAndCategory(String age, String category);

    @Query(value = "select distinct s.category from stat s", nativeQuery = true)
    List<String> findAllCategories();
}
