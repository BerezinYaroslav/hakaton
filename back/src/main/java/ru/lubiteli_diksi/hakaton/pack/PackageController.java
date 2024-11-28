package ru.lubiteli_diksi.hakaton.pack;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lubiteli_diksi.hakaton.channel.ChannelRepository;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class PackageController {
    private final PackageRepository repository;
    private final ChannelRepository channelRepository;

    @GetMapping
    public List<Package> getClients() {
        setChannelCount();
        return repository.findAll();
    }

    public void setChannelCount() {
        List<Package> packages = repository.findAll();
        packages.forEach(pack -> pack.setChannelCount(channelRepository.findChannelsCount(pack.getName())));
        packages.forEach(repository::save);
    }
}
