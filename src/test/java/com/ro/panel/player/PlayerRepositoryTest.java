package com.ro.panel.player;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository underTest;

    @Test
    void itShouldSavePlayer() {
        // Given
        Player player = new Player("user@gmail.com", "user", "password", "token", LocalDateTime.now(), LocalDateTime.now(), 1234, 10, LocalDateTime.now(), 1, 1200);
        underTest.save(player);

        // When
        Player playerFromDb = underTest.findById(player.getId()).get();

        // Then
        assert playerFromDb .getEmail().equals(player.getEmail());
    }

    @Test
    void itShouldGetPlayerById() {
        // Given
        Player player = new Player("user@gmail.com", "user", "password", "token", LocalDateTime.now(), LocalDateTime.now(), 1234, 10, LocalDateTime.now(), 1, 1200);
        underTest.save(player);

        // When
        Player playerFromDb = underTest.findById(player.getId()).get();

        // Then
        assert playerFromDb.getEmail().equals(player.getEmail());
    }

    @Test
    void itShouldGetAllPlayers() {
        // Given
        Player player1 = new Player("user1@gmail.com", "user", "password", "token", LocalDateTime.now(), LocalDateTime.now(), 1234, 10, LocalDateTime.now(), 1, 1200);
        Player player2 = new Player("user2@gmail.com", "user", "password", "token", LocalDateTime.now(), LocalDateTime.now(), 1234, 10, LocalDateTime.now(), 1, 1200);
        Player player3 = new Player("user3@gmail.com", "user", "password", "token", LocalDateTime.now(), LocalDateTime.now(), 1234, 10, LocalDateTime.now(), 1, 1200);
        underTest.save(player1);
        underTest.save(player2);
        underTest.save(player3);

        // When
        Iterable<Player> allPlayers = underTest.findAll();

        // Then
        assert allPlayers.spliterator().getExactSizeIfKnown() == 3;
    }
}