package ru.lubiteli_diksi.hakaton.client;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = {"http://51.250.92.174:5173", "http://51.250.92.174", "freedom-dashboard-tv.ru"}, allowedHeaders = "*")
public class ClientController {
    private final ClientService service;

    @GetMapping
    public List<Client> getClients() {
        return service.getClients();
    }

    @GetMapping(value = "/{client}")
    public Client getClientByClient(@PathVariable String client) {
        return service.findClientByClient(client);
    }

    @PostMapping(produces = "application/json")
    public Client addClient(@RequestBody @Valid Client client) {
        return service.addClient(client);
    }

    @PutMapping(produces = "application/json")
    public Client updateClient(@RequestBody @Valid Client client) {
        return service.updateClient(client);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteClients() {
        service.deleteClients();
    }

    @DeleteMapping(value = "/{client}", produces = "application/json")
    public void deleteClientByClient(@PathVariable String client) {
        service.deleteClientByClient(client);
    }
}
