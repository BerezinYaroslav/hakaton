package ru.lubiteli_diksi.hakaton.pack;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.lubiteli_diksi.hakaton.channel.ChannelRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PackageService {
    private final PackageRepository repository;
    private final ChannelRepository channelRepository;

    public List<Package> getPackages() {
        log.info("get channels");
        this.setChannelCount();
        return repository.findAll();
    }

    public void setChannelCount() {
        List<Package> packages = repository.findAll();
        packages.forEach(pack -> pack.setChannelCount(channelRepository.findChannelsCount(pack.getName())));
        packages.forEach(repository::save);
    }

    public Package addPackage(Package pack) {
        log.info("add a package");
        return repository.save(pack);
    }

    public Package findPackageByName(String name) {
        log.info("get package where package = {}", name);
        return repository.findById(name)
                .orElseThrow(() -> new RuntimeException("There is no a package " + name));
    }

    public Package updatePackage(Package pack) {
        log.info("update a package");
        return repository.save(pack);
    }

    public void deletePackages() {
        log.info("Delete packages");
        repository.deleteAll();
    }

    public void deletePackageByName(String name) {
        log.info("Delete a package " + name);
        repository.deleteById(name);
    }



}