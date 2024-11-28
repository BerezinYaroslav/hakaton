package ru.lubiteli_diksi.hakaton.channel;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lubiteli_diksi.hakaton.pack.PackageController;

import java.util.List;

@RestController
@RequestMapping("/channels")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class ChannelController {
    private final ChannelRepository repository;
    private final PackageController packageController;

    @GetMapping
    public List<Channel> getClients() {
        packageController.setChannelCount();
        return repository.findAll();
    }
}
