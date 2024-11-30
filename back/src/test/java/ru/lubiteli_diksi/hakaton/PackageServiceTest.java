package ru.lubiteli_diksi.hakaton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.lubiteli_diksi.hakaton.pack.Package;
import ru.lubiteli_diksi.hakaton.pack.PackageRepository;
import ru.lubiteli_diksi.hakaton.pack.PackageService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PackageServiceTest {

    @Mock
    private PackageRepository repository;

    @InjectMocks
    private PackageService packageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPackage_shouldSavePackage() {
        Package pack = Package.builder()
                .name("Basic")
                .channelCount(10)
                .build();

        when(repository.save(pack)).thenReturn(pack);

        Package savedPackage = packageService.addPackage(pack);

        assertNotNull(savedPackage);
        assertEquals("Basic", savedPackage.getName());
        assertEquals(10, savedPackage.getChannelCount());
        verify(repository, times(1)).save(pack);
    }

    @Test
    void getPackages_shouldReturnAllPackages() {
        List<Package> packages = Arrays.asList(
                new Package("Basic", 10),
                new Package("Premium", 20)
        );

        when(repository.findAll()).thenReturn(packages);

        List<Package> result = packageService.getPackages();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Basic", result.get(0).getName());
        assertEquals(10, result.get(0).getChannelCount());
        verify(repository, times(1)).findAll();
    }

    @Test
    void findPackageByName_shouldReturnPackageIfExists() {
        Package pack = new Package("Premium", 20);

        when(repository.findById("Premium")).thenReturn(Optional.of(pack));

        Package foundPackage = packageService.findPackageByName("Premium");

        assertNotNull(foundPackage);
        assertEquals("Premium", foundPackage.getName());
        assertEquals(20, foundPackage.getChannelCount());
        verify(repository, times(1)).findById("Premium");
    }

    @Test
    void findPackageByName_shouldThrowExceptionIfNotFound() {
        when(repository.findById("Nonexistent")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            packageService.findPackageByName("Nonexistent");
        });

        assertEquals("There is no a package Nonexistent", exception.getMessage());
        verify(repository, times(1)).findById("Nonexistent");
    }

    @Test
    void updatePackage_shouldSaveUpdatedPackage() {
        Package pack = Package.builder()
                .name("Basic")
                .channelCount(15)
                .build();

        when(repository.save(pack)).thenReturn(pack);

        Package updatedPackage = packageService.updatePackage(pack);

        assertNotNull(updatedPackage);
        assertEquals("Basic", updatedPackage.getName());
        assertEquals(15, updatedPackage.getChannelCount());
        verify(repository, times(1)).save(pack);
    }

    @Test
    void deletePackages_shouldDeleteAllPackages() {
        doNothing().when(repository).deleteAll();

        packageService.deletePackages();

        verify(repository, times(1)).deleteAll();
    }

    @Test
    void deletePackageByName_shouldDeleteSpecificPackage() {
        doNothing().when(repository).deleteById("Basic");

        packageService.deletePackageByName("Basic");

        verify(repository, times(1)).deleteById("Basic");
    }
}
