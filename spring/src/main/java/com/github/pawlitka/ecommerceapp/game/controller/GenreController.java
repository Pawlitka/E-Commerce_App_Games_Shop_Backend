package com.github.pawlitka.ecommerceapp.game.controller;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Genre;
import com.github.pawlitka.ecommerceapp.game.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@CrossOrigin(origins = "http://localhost:3000")


public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getAll() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        return genreService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
