package ru.lubiteli_diksi.hakaton.channel;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lubiteli_diksi.hakaton.address.Address;
import ru.lubiteli_diksi.hakaton.address.AddressService;
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
    private final ChannelService channelService;

    @GetMapping
    public List<Channel> getChannels() {
        return channelService.getChannels();
    }

    @GetMapping(value = "/{id}")
    public Channel getAddressById(@PathVariable Integer id) {
        return channelService.findChannelById(id);
    }

    @PostMapping(produces = "application/json")
    public Channel addChannel(@RequestBody @Valid Channel channel) {
        return channelService.addChannel(channel);
    }

    @PutMapping(produces = "application/json")
    public Channel updateAddress(@RequestBody @Valid Channel channel) {
        return channelService.updateChannel(channel);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteChannels() {
        channelService.deleteChannels();
    }

    @DeleteMapping(value = "/{id`}", produces = "application/json")
    public void deleteChannelById(@PathVariable Integer id) {
        channelService.deleteChannelById(id);
    }
}
