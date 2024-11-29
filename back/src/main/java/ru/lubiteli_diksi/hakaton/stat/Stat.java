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

    private Timestamp time_ch;

    private Integer channel_id;

    private String epg_name;

    private Timestamp time_epg;

    private Timestamp time_to_epg;

    private Integer duration;

    private String category;

    private String subcategory;
}
