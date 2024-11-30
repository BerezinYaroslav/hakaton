package ru.lubiteli_diksi.hakaton.address;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address addAddress(Address address) {
        log.info("add a address");
        return addressRepository.save(address);
    }

    public List<Address> getAddresses() {
        log.info("get addresses");
        return addressRepository.findAll();
    }

    public Address findAddressByAddress(String address) {
        log.info("get address where id = {}", address);
        return addressRepository.findById(address)
                .orElseThrow(() -> new RuntimeException("There is no a address " + address));
    }

    public Address updateAddress(Address address) {
        log.info("update a address");
        return addressRepository.save(address);
    }

    public void deleteAddresses() {
        log.info("Delete addresses");
        addressRepository.deleteAll();
    }

    public void deleteAddressByAddress(String address) {
        log.info("Delete a address with address {}", address);
        addressRepository.deleteById(address);
    }
}
