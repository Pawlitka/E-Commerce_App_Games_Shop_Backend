package pl.pawlitka.store.controllers;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pawlitka.store.dtos.GameDetailsDto;
import pl.pawlitka.store.dtos.UserDto;
import pl.pawlitka.store.mappers.GameDetailsMapper;
import pl.pawlitka.store.repositories.GameDetailsRepository;

import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/game-details")
public class GameDetailsController {
    private final GameDetailsRepository gameDetailsRepository;
    private final GameDetailsMapper gameDetailsMapper;

    @GetMapping
     public Iterable<GameDetailsDto> getAllUsers(
            @RequestParam(required = false, defaultValue = "", name="sort") String sortBy
    ) {
        if(!Set.of("title", "price").contains(sortBy))
            sortBy = "title";

        return gameDetailsRepository.findAll(Sort.by(sortBy)).stream()
                .map(gameDetailsMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDetailsDto> getGameDetails(@PathVariable Long id) {
        var gameDetails = gameDetailsRepository.findById(id).orElse(null);
        if(gameDetails == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(gameDetailsMapper.toDto(gameDetails));
    }
}
