package ru.lubiteli_diksi.hakaton.stat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lubiteli_diksi.hakaton.client.Client;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stat")
@Schema(name = "Statistics", description = "Statistics entity")
public class Stat {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "client")
    private Client client;

    private String device;

    @Column(name = "time_ch")
    private LocalDateTime timeCh;

    @Column(name = "channel_id")
    private Integer channelId;

    @Column(name = "epg_name")
    private String epgName;

    @Column(name = "time_epg")
    private LocalDateTime timeEpg;

    @Column(name = "time_to_epg")
    private LocalDateTime timeToEpg;

    private Integer duration;

    private String category;

    private String subcategory;
}
