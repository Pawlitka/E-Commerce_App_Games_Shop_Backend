package com.github.pawlitka.ecommerceapp.game.controller;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Game;
import com.github.pawlitka.ecommerceapp.game.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAll() {
        return gameService.getAllGames();
    }
}
