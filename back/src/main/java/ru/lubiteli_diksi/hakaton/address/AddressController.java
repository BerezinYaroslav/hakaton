package ru.lubiteli_diksi.hakaton.address;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class AddressController {
    private final AddressRepository repository;

    @GetMapping
    public List<Address> getClients() {
        return repository.findAll().stream()
                .filter(address -> address.getFloors().length() <= 3)
                .toList();
    }
}
