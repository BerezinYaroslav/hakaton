package ru.lubiteli_diksi.hakaton.channel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChannelService {
    private final ChannelRepository repository;

    public Channel addChannel(Channel address) {
        log.info("add a chanel");
        return repository.save(address);
    }

    public List<Channel> getChannels() {
        log.info("get channels");
        return repository.findAll();
    }

    public Channel findChannelById(Integer id) {
        log.info("get chanel where id = {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no a id " + id));
    }

    public Channel updateChannel(Channel channel) {
        log.info("update a channel");
        return repository.save(channel);
    }

    public void deleteChannels() {
        log.info("Delete channels");
        repository.deleteAll();
    }

    public void deleteChannelById(Integer id) {
        log.info("Delete a id " + id);
        repository.deleteById(id);
    }

}
