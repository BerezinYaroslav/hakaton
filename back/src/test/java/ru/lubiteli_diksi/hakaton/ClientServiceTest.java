package ru.lubiteli_diksi.hakaton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.lubiteli_diksi.hakaton.address.Address;
import ru.lubiteli_diksi.hakaton.client.Client;
import ru.lubiteli_diksi.hakaton.client.ClientRepository;
import ru.lubiteli_diksi.hakaton.client.ClientService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {
    @Mock
    private ClientRepository repository;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addClient_shouldSaveClient() {
        Address address = Address.builder()
                .address("Test Street 1")
                .flats(10)
                .entrances(2)
                .floors("5")
                .coordinates("55.7558,37.6173")
                .build();

        Client client = Client.builder()
                .client("client1")
                .address(address)
                .gender("Male")
                .age("25")
                .build();

        when(repository.save(client)).thenReturn(client);

        Client savedClient = clientService.addClient(client);

        assertNotNull(savedClient);
        assertEquals("client1", savedClient.getClient());
        assertEquals("Test Street 1", savedClient.getAddress().getAddress());
        verify(repository, times(1)).save(client);
    }

    @Test
    void getClients_shouldReturnAllClients() {
        Address address1 = new Address("Address 1", 10, 2, "5", "55.7558,37.6173");
        Address address2 = new Address("Address 2", 20, 3, "10", "56.7558,38.6173");

        List<Client> clients = Arrays.asList(
                new Client("client1", address1, "Male", "25"),
                new Client("client2", address2, "Female", "30")
        );

        when(repository.findAll()).thenReturn(clients);

        List<Client> result = clientService.getClients();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Male", result.get(0).getGender());
        assertEquals("Female", result.get(1).getGender());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findClientByClient_shouldReturnClientIfExists() {
        Address address = new Address("Test Street 1", 10, 2, "5", "55.7558,37.6173");
        Client client = new Client("client1", address, "Male", "25");

        when(repository.findById("client1")).thenReturn(Optional.of(client));

        Client foundClient = clientService.findClientByClient("client1");

        assertNotNull(foundClient);
        assertEquals("client1", foundClient.getClient());
        assertEquals("Male", foundClient.getGender());
        verify(repository, times(1)).findById("client1");
    }

    @Test
    void findClientByClient_shouldThrowExceptionIfNotFound() {
        when(repository.findById("nonexistent")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            clientService.findClientByClient("nonexistent");
        });

        assertEquals("There is no a client nonexistent", exception.getMessage());
        verify(repository, times(1)).findById("nonexistent");
    }

    @Test
    void updateClient_shouldSaveUpdatedClient() {
        Address address = Address.builder()
                .address("Test Street 2")
                .flats(20)
                .entrances(4)
                .floors("10")
                .coordinates("55.7558,37.6173")
                .build();

        Client client = Client.builder()
                .client("client1")
                .address(address)
                .gender("Male")
                .age("30")
                .build();

        when(repository.save(client)).thenReturn(client);

        Client updatedClient = clientService.updateClient(client);

        assertNotNull(updatedClient);
        assertEquals("client1", updatedClient.getClient());
        assertEquals("30", updatedClient.getAge());
        verify(repository, times(1)).save(client);
    }

    @Test
    void deleteClients_shouldDeleteAllClients() {
        doNothing().when(repository).deleteAll();

        clientService.deleteClients();

        verify(repository, times(1)).deleteAll();
    }

    @Test
    void deleteClientByClient_shouldDeleteSpecificClient() {
        doNothing().when(repository).deleteById("client1");

        clientService.deleteClientByClient("client1");

        verify(repository, times(1)).deleteById("client1");
    }
}
