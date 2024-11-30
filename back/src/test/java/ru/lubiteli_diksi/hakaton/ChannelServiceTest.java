package ru.lubiteli_diksi.hakaton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.lubiteli_diksi.hakaton.channel.Channel;
import ru.lubiteli_diksi.hakaton.channel.ChannelRepository;
import ru.lubiteli_diksi.hakaton.channel.ChannelService;
import ru.lubiteli_diksi.hakaton.pack.Package;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChannelServiceTest {
    @Mock
    private ChannelRepository channelRepository;

    @InjectMocks
    private ChannelService channelService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addChannel_shouldSaveChannel() {
        Package pack = new Package("Basic");
        Channel channel = Channel.builder()
                .id(1)
                .pack(pack)
                .build();

        when(channelRepository.save(channel)).thenReturn(channel);

        Channel savedChannel = channelService.addChannel(channel);

        assertNotNull(savedChannel);
        assertEquals(1, savedChannel.getId());
        assertEquals("Basic", savedChannel.getPack().getName());
        verify(channelRepository, times(1)).save(channel);
    }

    @Test
    void getChannels_shouldReturnAllChannels() {
        Package pack1 = new Package("Basic");
        Package pack2 = new Package("Premium");
        List<Channel> channels = Arrays.asList(
                new Channel(1, pack1),
                new Channel(2, pack2)
        );

        when(channelRepository.findAll()).thenReturn(channels);

        List<Channel> result = channelService.getChannels();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Basic", result.get(0).getPack().getName());
        assertEquals("Premium", result.get(1).getPack().getName());
        verify(channelRepository, times(1)).findAll();
    }

    @Test
    void findChannelById_shouldReturnChannelIfExists() {
        Package pack = new Package("Basic");
        Channel channel = new Channel(1, pack);

        when(channelRepository.findById(1)).thenReturn(Optional.of(channel));

        Channel foundChannel = channelService.findChannelById(1);

        assertNotNull(foundChannel);
        assertEquals(1, foundChannel.getId());
        assertEquals("Basic", foundChannel.getPack().getName());
        verify(channelRepository, times(1)).findById(1);
    }

    @Test
    void findChannelById_shouldThrowExceptionIfNotFound() {
        when(channelRepository.findById(999)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            channelService.findChannelById(999);
        });

        assertEquals("There is no a id 999", exception.getMessage());
        verify(channelRepository, times(1)).findById(999);
    }

    @Test
    void updateChannel_shouldSaveUpdatedChannel() {
        Package pack = new Package("Premium");
        Channel channel = Channel.builder()
                .id(1)
                .pack(pack)
                .build();

        when(channelRepository.save(channel)).thenReturn(channel);

        Channel updatedChannel = channelService.updateChannel(channel);

        assertNotNull(updatedChannel);
        assertEquals(1, updatedChannel.getId());
        assertEquals("Premium", updatedChannel.getPack().getName());
        verify(channelRepository, times(1)).save(channel);
    }

    @Test
    void deleteChannels_shouldDeleteAllChannels() {
        doNothing().when(channelRepository).deleteAll();

        channelService.deleteChannels();

        verify(channelRepository, times(1)).deleteAll();
    }

    @Test
    void deleteChannelById_shouldDeleteSpecificChannel() {
        doNothing().when(channelRepository).deleteById(1);

        channelService.deleteChannelById(1);

        verify(channelRepository, times(1)).deleteById(1);
    }
}
