package ru.lubiteli_diksi.hakaton.channel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lubiteli_diksi.hakaton.pack.Package;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "channel")
public class Channel {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "package", referencedColumnName = "name")
    private Package pack;
}
