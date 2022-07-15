package com.ro.panel.player;

import com.ro.panel.player.exeption.PlayerRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Slf4j
@Validated
@RestController
@RequestMapping("/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers(){
        Iterable<Player> playerRepositoryAll = playerService.getAllPlayers();
        return ResponseEntity.ok((List<Player>) playerRepositoryAll);
    }

    @GetMapping("/{id}")
    @Validated
    public ResponseEntity<?> getPlayer(@PathVariable @Min(1) Integer id){
        Optional<Player> player = playerService.getPlayerById(id);
//        log.info("Player Retrieved: {}", player.orElse(new Player()));
        String eMessage = String.format("Player with id: %d not found.", id);
        return ResponseEntity.ok(player.orElseThrow(() -> new PlayerRequestException(eMessage)));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPlayer(@RequestBody PlayerRequest playerRequest){
        Player newPlayer = new Player();
        newPlayer.setName(playerRequest.name());
        newPlayer.setEmail(playerRequest.email());
        newPlayer.setPassword(playerRequest.password());
        newPlayer.setPin_code(playerRequest.pin_code());
        newPlayer.setCreated_at(LocalDateTime.now());
        newPlayer.setFb_points(0);
        newPlayer.setLevel(0);
        newPlayer.setCash_points(0);
        playerService.createPlayer(newPlayer);
        return ResponseEntity.ok("Player Created");
    }

}
