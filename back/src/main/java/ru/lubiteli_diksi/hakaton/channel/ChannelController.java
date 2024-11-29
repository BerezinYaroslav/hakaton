package ru.lubiteli_diksi.hakaton.channel;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173", allowedHeaders = "*")
public class ChannelController {
    private final ChannelService service;

    @GetMapping
    public List<Channel> getChannels() {
        return service.getChannels();
    }

    @GetMapping(value = "/{id}")
    public Channel getChannelById(@PathVariable Integer id) {
        return service.findChannelById(id);
    }

    @PostMapping(produces = "application/json")
    public Channel addChannel(@RequestBody @Valid Channel channel) {
        return service.addChannel(channel);
    }

    @PutMapping(produces = "application/json")
    public Channel updateChannel(@RequestBody @Valid Channel channel) {
        return service.updateChannel(channel);
    }

    @DeleteMapping(produces = "application/json")
    public void deleteChannels() {
        service.deleteChannels();
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public void deleteChannelById(@PathVariable Integer id) {
        service.deleteChannelById(id);
    }
}
