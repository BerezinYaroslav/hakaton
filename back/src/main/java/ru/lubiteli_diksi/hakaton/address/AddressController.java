package ru.lubiteli_diksi.hakaton.address;

import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.getAddresses().stream()
                .filter(address -> address.getFloors().length() <= 3)
                .toList();
    }

    @GetMapping(value = "/{address}")
    public Address getAddressByAddress(@PathVariable String address) {
        return addressService.findAddressByAddress(address);
    }

    @PostMapping(produces = "application/json")
    public Address addAddress(@RequestBody @Valid Address address) {
        return addressService.addAddress(address);
    }

    @PutMapping(produces = "application/json")
    public Address updateAddress(@RequestBody @Valid Address address) {
        return addressService.updateAddress(address);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteAddresses() {
        addressService.deleteAddresses();
    }

    @DeleteMapping(value = "/{address}", produces = "application/json")
    public void deleteAddressByAddress(@PathVariable String address) {
        addressService.deleteAddressByAddress(address);
    }
}
