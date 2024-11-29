package ru.lubiteli_diksi.hakaton.pack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "channel_package")
public class Package {
    @Id
    private String name;

    @Column(name = "channel_count")
    private Integer channelCount;
}
