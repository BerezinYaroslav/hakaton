package ru.lubiteli_diksi.hakaton.channel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
    @Query(value = "SELECT count(*) FROM channel where package = ?1", nativeQuery = true)
    Integer findChannelsCount(String packageName);
}