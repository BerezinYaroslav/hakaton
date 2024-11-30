package ru.lubiteli_diksi.hakaton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.lubiteli_diksi.hakaton.address.Address;
import ru.lubiteli_diksi.hakaton.address.AddressRepository;
import ru.lubiteli_diksi.hakaton.address.AddressService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addAddress_shouldSaveAddress() {
        Address address = Address.builder()
                .address("Test Street 1")
                .flats(10)
                .entrances(2)
                .floors("5")
                .coordinates("55.7558,37.6173")
                .build();

        when(addressRepository.save(address)).thenReturn(address);

        Address savedAddress = addressService.addAddress(address);

        assertNotNull(savedAddress);
        assertEquals("Test Street 1", savedAddress.getAddress());
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void getAddresses_shouldReturnAllAddresses() {
        List<Address> addresses = Arrays.asList(
                new Address("Address 1", 10, 2, "5", "55.7558,37.6173"),
                new Address("Address 2", 20, 3, "10", "56.7558,38.6173")
        );

        when(addressRepository.findAll()).thenReturn(addresses);

        List<Address> result = addressService.getAddresses();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void findAddressByAddress_shouldReturnAddressIfExists() {
        Address address = new Address("Test Street 1", 10, 2, "5", "55.7558,37.6173");

        when(addressRepository.findById("Test Street 1")).thenReturn(Optional.of(address));

        Address foundAddress = addressService.findAddressByAddress("Test Street 1");

        assertNotNull(foundAddress);
        assertEquals("Test Street 1", foundAddress.getAddress());
        verify(addressRepository, times(1)).findById("Test Street 1");
    }

    @Test
    void findAddressByAddress_shouldThrowExceptionIfNotFound() {
        when(addressRepository.findById("Nonexistent Address")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            addressService.findAddressByAddress("Nonexistent Address");
        });

        assertEquals("There is no a address Nonexistent Address", exception.getMessage());
        verify(addressRepository, times(1)).findById("Nonexistent Address");
    }

    @Test
    void updateAddress_shouldSaveUpdatedAddress() {
        Address address = Address.builder()
                .address("Test Street 1")
                .flats(12)
                .entrances(3)
                .floors("6")
                .coordinates("55.7558,37.6173")
                .build();

        when(addressRepository.save(address)).thenReturn(address);

        Address updatedAddress = addressService.updateAddress(address);

        assertNotNull(updatedAddress);
        assertEquals(12, updatedAddress.getFlats());
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void deleteAddresses_shouldDeleteAllAddresses() {
        doNothing().when(addressRepository).deleteAll();

        addressService.deleteAddresses();

        verify(addressRepository, times(1)).deleteAll();
    }

    @Test
    void deleteAddressByAddress_shouldDeleteSpecificAddress() {
        doNothing().when(addressRepository).deleteById("Test Street 1");

        addressService.deleteAddressByAddress("Test Street 1");

        verify(addressRepository, times(1)).deleteById("Test Street 1");
    }
}
