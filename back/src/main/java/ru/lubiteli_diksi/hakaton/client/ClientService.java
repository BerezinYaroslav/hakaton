package ru.lubiteli_diksi.hakaton.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;

    public Client addClient(Client client) {
        log.info("add a client");
        return repository.save(client);
    }

    public List<Client> getClients() {
        log.info("get clients");
        return repository.findAll();
    }

    public Client findClientByClient(String client) {
        log.info("get client where client = {}", client);
        return repository.findById(client)
                .orElseThrow(() -> new RuntimeException("There is no a client " + client));
    }

    public Client updateClient(Client client) {
        log.info("update a client");
        return repository.save(client);
    }

    public void deleteClients() {
        log.info("Delete clients");
        repository.deleteAll();
    }

    public void deleteClientByClient(String client) {
        log.info("Delete a client with id {}", client);
        repository.deleteById(client);
    }
}