package com.github.pawlitka.ecommerceapp.game.controller;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Game;
import com.github.pawlitka.ecommerceapp.game.dto.GameDto;
import com.github.pawlitka.ecommerceapp.game.mapper.GameMapper;
import com.github.pawlitka.ecommerceapp.game.repository.GameRepository;
import com.github.pawlitka.ecommerceapp.game.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public GameController(GameRepository gameRepository,GameMapper gameMapper) {
        this.gameRepository = gameRepository;
        this.gameMapper = gameMapper;
    }

    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGames() {
        List<Game> games = gameRepository.findAllWithGenresAndPlatforms();

        List<GameDto> gamesDtos = gameMapper.toDtoList(games);
        return ResponseEntity.ok(gamesDtos);
    }
}
