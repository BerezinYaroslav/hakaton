package ru.lubiteli_diksi.hakaton.client;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.lubiteli_diksi.hakaton.address.Address;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Schema(name = "Client", description = "Client entity")
public class Client {
    @Id
    private String client;

    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "address")
    private Address address;

    private String gender;

    private String age;
}
