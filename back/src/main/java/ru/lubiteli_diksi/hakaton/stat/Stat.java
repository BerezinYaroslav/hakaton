package ru.lubiteli_diksi.hakaton.stat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lubiteli_diksi.hakaton.client.Client;

import java.security.Timestamp;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stat")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "client")
    private Client client;

    private String device;

    @Column(name = "time_ch")
    private Timestamp timeCh;

    @Column(name = "channel_id")
    private Integer channelId;

    @Column(name = "epg_name")
    private String epgName;

    @Column(name = "time_epg")
    private Timestamp timeEpg;

    @Column(name = "time_to_epg")
    private Timestamp timeToEpg;

    private Integer duration;

    private String category;

    private String subcategory;
}
