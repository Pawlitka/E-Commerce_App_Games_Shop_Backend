package pl.pawlitka.store.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pawlitka.store.dtos.GameDetailsDto;
import pl.pawlitka.store.mappers.GameDetailsMapper;
import pl.pawlitka.store.repositories.GameDetailsRepository;

@RestController
@AllArgsConstructor
@RequestMapping("/game-details")
public class GameDetailsController {
    private final GameDetailsRepository gameDetailsRepository;
    private final GameDetailsMapper gameDetailsMapper;

    @GetMapping
    public Iterable<GameDetailsDto> getAllGameDetails() {
        return gameDetailsRepository.findAllActive().stream()
                .map(gameDetailsMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDetailsDto> getGameDetails(@PathVariable Long id) {
        var gameDetails = gameDetailsRepository.findById(id).orElse(null);
        if (gameDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gameDetailsMapper.toDto(gameDetails));
    }
}
