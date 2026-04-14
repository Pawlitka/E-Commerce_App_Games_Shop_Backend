package com.github.pawlitka.ecommerceapp.game.service;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Game;
import com.github.pawlitka.ecommerceapp.game.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
