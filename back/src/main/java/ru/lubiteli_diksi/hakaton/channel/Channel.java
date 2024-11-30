package ru.lubiteli_diksi.hakaton.channel;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "Channel", description = "Channel entity")
public class Channel {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "package", referencedColumnName = "name")
    private Package pack;
}
