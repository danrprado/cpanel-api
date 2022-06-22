package com.ro.panel.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository; // mockito mock object for PlayerRepository interface
    private PlayerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayerService(playerRepository);
    }

    @Test
    void itShouldGetAllPlayers() {
        // Given
        when(playerRepository.findAll()).thenReturn(List.of( new Player() ));
        // When
        underTest.getAllPlayers();
        // Then
        verify(playerRepository).findAll(); // verify that findAll() method was called on playerRepository
    }

    @Test
    void itShouldGetPlayerById() {
        // Given
        when(playerRepository.findById(1)).thenReturn(Optional.of(new Player()));
        // When
        underTest.getPlayerById(1);
        // Then
        verify(playerRepository).findById(1); // verify that findById() method was called on playerRepository

    }

    @Test
    void itShouldCreatePlayer() {
        // Given
        Player player = new Player("user@gmail.com", "user", "password", "token", LocalDateTime.now(), LocalDateTime.now(), 1234, 10, LocalDateTime.now(), 1, 1200);
        // When
        underTest.createPlayer(player); // createPlayer() method is called on PlayerService
        // Then
        ArgumentCaptor<Player> argumentCaptor = ArgumentCaptor.forClass(Player.class); // ArgumentCaptor is a class from Mockito library
        verify(playerRepository).save(argumentCaptor.capture()); // verify that save() method was called on playerRepository
        Player capturedPlayer = argumentCaptor.getValue(); // get the value of the argumentCaptor
        assertThat(capturedPlayer).isEqualTo(player); // assert that capturedPlayer is equal to player
    }
}