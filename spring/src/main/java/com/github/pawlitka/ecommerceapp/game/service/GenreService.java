package com.github.pawlitka.ecommerceapp.game.service;

import com.github.pawlitka.ecommerceapp.game.domain.entity.Genre;
import com.github.pawlitka.ecommerceapp.game.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
