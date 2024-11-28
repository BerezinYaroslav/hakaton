package ru.lubiteli_diksi.hakaton.client;

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
public class Client {
    @Id
    private String client;

    @ManyToOne
    @JoinColumn(name = "address", referencedColumnName = "address")
    private Address address;

    private String gender;

    private String age;
}
