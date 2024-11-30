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

    @Query(value = "select c.package, to_char(cast(ceil(avg(s.sum)) as numeric), 'FM999999999') avg_time " +
            "from (select channel_id, sum(duration) sum from stat s group by channel_id) s " +
            "         join channel c on s.channel_id = c.id " +
            "group by c.package " +
            "having package = ?1 " +
            "order by avg_time desc", nativeQuery = true)
    Map<String, String> findAverageTimeByChannelPackage(String channel);
}
