package ru.lubiteli_diksi.hakaton.pack;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lubiteli_diksi.hakaton.stat.Stat;

import java.util.List;

@RestController
@RequestMapping("/packages")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class PackageController {
    private final PackageService service;

    @GetMapping
    public List<Package> getPackages() {
        service.setChannelCount();
        return service.getPackages();
    }

    @GetMapping(value = "/{id}")
    public Package getPackageByName(@PathVariable String name) {
        return service.findPackageByName(name);
    }

    @PostMapping(produces = "application/json")
    public Package addPackage(@RequestBody @Valid Package pack) {
        return service.addPackage(pack);
    }

    @PutMapping(produces = "application/json")
    public Package updatePackage(@RequestBody @Valid Package pack) {
        return service.updatePackage(pack);
    }

    @DeleteMapping(produces = "application/json")
    public void deletePackages() {
        service.deletePackages();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deletePackageByName(@PathVariable String name) {
        service.deletePackageByName(name);
    }
}
