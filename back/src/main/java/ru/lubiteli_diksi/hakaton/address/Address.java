package ru.lubiteli_diksi.hakaton.address;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
@Schema(name = "Address", description = "Address entity")
public class Address {
    @Id
    private String address;

    private Integer flats;

    private Integer entrances;

    private String floors;

    private String coordinates;
}
