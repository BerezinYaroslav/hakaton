package ru.lubiteli_diksi.hakaton.address;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class AddressController {
    private final AddressService service;

    @GetMapping(produces = "application/json")
    public List<Address> getAddresses() {
        return service.getAddresses().stream()
                .filter(address -> address.getFloors().length() <= 3)
                .toList();
    }

    @GetMapping(value = "/{address}", produces = "application/json")
    public Address getAddressByAddress(@PathVariable String address) {
        return service.findAddressByAddress(address);
    }


    @PostMapping(produces = "application/json")
    public Address addAddress(@RequestBody @Valid Address address) {
        return service.addAddress(address);
    }

    @PutMapping(produces = "application/json")
    public Address updateAddress(@RequestBody @Valid Address address) {
        return service.updateAddress(address);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteAddresses() {
        service.deleteAddresses();
    }

    @DeleteMapping(value = "/{address}", produces = "application/json")
    public void deleteAddressByAddress(@PathVariable String address) {
        service.deleteAddressByAddress(address);
    }
}
